package com.dgpay.endpoing.notification.rest;

import com.dgpay.endpoing.notification.dto.NotificationRequest;
import com.dgpay.endpoing.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
@RestController
@RequestMapping("/notification/v1/messages")
public class NotificationRestController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping(value = "send")
    public void receive(@RequestBody NotificationRequest notificationRequest) {

        notificationService.process(notificationRequest);


    }
}
