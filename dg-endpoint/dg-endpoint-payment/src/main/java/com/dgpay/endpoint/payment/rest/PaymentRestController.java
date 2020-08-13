package com.dgpay.endpoint.payment.rest;

import com.dgpay.endpoint.payment.dto.*;
import com.dgpay.external.client.service.Provider1Service;
import com.dgpay.external.client.service.Provider2Service;
import com.dgpay.persistence.sw.model.card.Card;
import com.dgpay.persistence.sw.servcie.card.CardPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping(value = "transfer")
    public void transfer(@RequestBody TransferRequest request) {

        String pan = request.getPan();

        HashMap<String, Object> holder = new HashMap<>();
        holder.put("pan", pan);
        holder.put("destination", request.getDestination());
        holder.put("cvv2", request.getCvv2());
        holder.put("expireDate", request.getExpireDate());
        holder.put("pin2", request.getPin2());
        holder.put("amount", request.getAmount());

        boolean process = false;
        if (pan.substring(0, 4).equals("6037")) {
            process = provider1Service.process(holder);
        } else {
            process = provider2Service.process(holder);
        }

        if (process){
            // TODO: 8/13/2020 send sms
        }

    }
}
