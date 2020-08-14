package com.dgpay.application.payment.external.feign;

import com.dgpay.application.payment.dto.ProviderExternalRequest;
import com.dgpay.application.payment.dto.ProviderExternalResponse;
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
@FeignClient(name = "ProviderExternal", path = "/first-payment-provider/payments"
        , configuration = ProviderExternalFeignClientConfiguration.class, fallbackFactory = ProviderExternalFeignClientFallbackFactory.class,
        primary = true)
@RequestMapping(headers = {"Cache-Control= no-cache"}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public interface ProviderExternalFeignClient {

    @PostMapping(path = "/transfer")
    ResponseEntity<ProviderExternalResponse> sendRequest(@RequestBody ProviderExternalRequest request) throws FeignException;
}
