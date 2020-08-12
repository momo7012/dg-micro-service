package com.dgpay.external.notification.feign;


import com.dgpay.external.notification.dto.NotificationRequest;
import com.dgpay.external.notification.dto.NotificationResponse;
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
@FeignClient(name = "NotificationExternal", path = "/sms-provider/messages"
        , configuration = NotificationFeignClientConfiguration.class, fallbackFactory = NotificationFeignClientFallbackFactory.class,
        primary = true)
@RequestMapping(headers = {"Cache-Control= no-cache"}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public interface NotificationFeignClient {

    @PostMapping(path = "/send-sms")
    ResponseEntity<NotificationResponse> sendRequest(@RequestBody NotificationRequest request) throws FeignException;
}
