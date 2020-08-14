package com.dgpay.application.payment.rest;

import com.dgpay.application.payment.dto.*;

import com.dgpay.application.payment.external.service.Provider1Service;
import com.dgpay.application.payment.external.service.Provider2Service;
import com.dgpay.application.payment.internal.feign.NotificationInternalFeignClient;
import com.dgpay.persistence.sw.model.card.Card;
import com.dgpay.persistence.sw.model.customer.Customer;
import com.dgpay.persistence.sw.servcie.card.CardPersistenceService;
import com.dgpay.persistence.sw.servcie.customer.CustomerPersistenceService;
import com.dgpay.persistence.sw.servcie.transaction.RequestPersistenceService;
import com.dgpay.persistence.sw.servcie.transaction.ResponsePersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
@RestController
@RequestMapping("/payment/v1/service/")
public class PaymentRestController {

    @Autowired
    private Provider1Service provider1Service;

    @Autowired
    private Provider2Service provider2Service;

    @Autowired
    private NotificationInternalFeignClient notificationInternalFeignClient;

    @Autowired
    private RequestPersistenceService requestPersistenceService;

    @Autowired
    private ResponsePersistenceService responsePersistenceService;

    @Autowired
    private CustomerPersistenceService customerPersistenceService;

    @Autowired
    private CardPersistenceService cardPersistenceService;


    @PostMapping(value = "transfer")
    public void transfer(@RequestBody TransferRequest request) {

        String pan = request.getPan();

        Card cardInfo = cardPersistenceService.getCardInfo(pan);
        if (cardInfo == null) {
            return;
        }

        HashMap<String, Object> holder = new HashMap<>();
        holder.put("pan", pan);
        holder.put("destination", request.getDestination());
        holder.put("cvv2", request.getCvv2());
        holder.put("expireDate", request.getExpireDate());
        holder.put("pin2", request.getPin2());
        holder.put("amount", request.getAmount());
        holder.put("rrn", request.getRefrence_number());


        Long trno = requestPersistenceService.insertRequest(holder);
        boolean process = false;
        if (pan.substring(0, 4).equals("6037")) {
            process = provider1Service.process(holder);
        } else {
            process = provider2Service.process(holder);
        }

        if (process) {

            Customer customer = customerPersistenceService.getCustomer(cardInfo.getCustomer_uid());

            NotificationInternalRequest notificationInternalRequest = new NotificationInternalRequest();
            notificationInternalRequest.setMessage("Transaction is successful");
            notificationInternalRequest.setMobile(customer.getMobile_no());

            notificationInternalFeignClient.sendRequest(new NotificationInternalRequest());

            responsePersistenceService.insertResponse(trno, 0);

        }
        responsePersistenceService.insertResponse(trno, 9);

    }
}
