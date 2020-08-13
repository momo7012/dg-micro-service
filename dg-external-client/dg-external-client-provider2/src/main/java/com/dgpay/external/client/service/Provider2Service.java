package com.dgpay.external.client.service;

import com.dgpay.external.client.dto.Provider2ExternalRequest;
import com.dgpay.external.client.dto.Provider2ExternalResponse;
import com.dgpay.external.client.feign.Provider2ExternalFeignClient;
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
public class Provider2Service {

    @Autowired
    private Provider2ExternalFeignClient provider2ExternalFeignClient;

    public boolean process(HashMap<String, Object> holder) {

        Provider2ExternalRequest providerExternalRequest = new Provider2ExternalRequest();

        providerExternalRequest.setAmount((Long) holder.get("amount"));
        providerExternalRequest.setCvv2((String) holder.get("cvv2"));
        providerExternalRequest.setTarget((String) holder.get("destination"));
        providerExternalRequest.setExpire((String) holder.get("expireDate"));
        providerExternalRequest.setPin2((String) holder.get("pin2"));
        providerExternalRequest.setSource((String) holder.get("pan"));

        ResponseEntity<Provider2ExternalResponse> provider2ExternalResponseResponseEntity = provider2ExternalFeignClient.sendRequest(providerExternalRequest);

        HttpStatus statusCode = provider2ExternalResponseResponseEntity.getStatusCode();
        if (statusCode.is2xxSuccessful()){
            return true;
        }
        return false;
    }
}
