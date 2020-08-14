package com.dgpay.application.payment.external.service;

import com.dgpay.application.payment.dto.ProviderExternalRequest;
import com.dgpay.application.payment.dto.ProviderExternalResponse;
import com.dgpay.application.payment.external.feign.ProviderExternalFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;


/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
@Service
public class Provider1Service implements ProviderService {

    @Autowired
    private ProviderExternalFeignClient providerExternalFeignClient;

    public boolean process(HashMap<String, Object> holder) {

        ProviderExternalRequest providerExternalRequest = new ProviderExternalRequest();


        providerExternalRequest.setAmount((Long) holder.get("amount"));
        providerExternalRequest.setCvv2((String) holder.get("cvv2"));
        providerExternalRequest.setDest((String) holder.get("destination"));
        providerExternalRequest.setExpDate((String) holder.get("expireDate"));
        providerExternalRequest.setPin((String) holder.get("pin2"));
        providerExternalRequest.setSource((String) holder.get("pan"));

        ResponseEntity<ProviderExternalResponse> providerExternalResponseResponseEntity = providerExternalFeignClient.sendRequest(providerExternalRequest);

        HttpStatus statusCode = providerExternalResponseResponseEntity.getStatusCode();
        if (statusCode.is2xxSuccessful()) {
            return true;
        }
        return false;

    }
}
