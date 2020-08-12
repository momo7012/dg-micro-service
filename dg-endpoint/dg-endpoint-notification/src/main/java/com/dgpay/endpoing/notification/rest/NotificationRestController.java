package com.dgpay.endpoing.notification.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
@RestController
@RequestMapping("/notification/v1/messages")
public class NotificationRestController {


    @PostMapping(value = "send")
    public void receive(){

    }
}
