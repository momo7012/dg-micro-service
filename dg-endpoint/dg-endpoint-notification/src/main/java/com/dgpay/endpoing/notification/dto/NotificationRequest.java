package com.dgpay.endpoing.notification.dto;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/14/2020
 */
public class NotificationRequest {

    private String mobile;
    private String message;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
