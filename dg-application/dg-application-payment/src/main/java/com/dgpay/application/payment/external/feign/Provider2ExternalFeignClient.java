package com.dgpay.application.payment.external.feign;

import com.dgpay.application.payment.dto.Provider2ExternalRequest;
import com.dgpay.application.payment.dto.Provider2ExternalResponse;
import feign.FeignException;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
@FeignClient(name = "Provider2External", path = "/second-payment-provider/cards/pay"
        , configuration = Provider2ExternalFeignClientConfiguration.class, fallbackFactory = Provider2ExternalFeignClientFallbackFactory.class,
        primary = true)
@RequestMapping(headers = {"Cache-Control= no-cache"}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public interface Provider2ExternalFeignClient {

    @PostMapping(path = "/post-pay")
    ResponseEntity<Provider2ExternalResponse> sendRequest(@RequestBody Provider2ExternalRequest request) throws FeignException;
}
