package com.dgpay.endpoint.payment.feign;

import com.dgpay.endpoint.payment.dto.NotificationInternalRequest;
import com.dgpay.endpoint.payment.dto.NotificationInternalResponse;
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
@FeignClient(name = "NotificationInternal", path = "/notification/v1/messages"
        , configuration = NotificationInternalFeignConfiguration.class, fallbackFactory = NotificationInternalFeignFallbackFactory.class,
        primary = true)
@RequestMapping(headers = {"Cache-Control= no-cache"}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public interface NotificationInternalFeignClient {

    @PostMapping(path = "/send")
    ResponseEntity<NotificationInternalResponse> sendRequest(@RequestBody NotificationInternalRequest request) throws FeignException;
}
