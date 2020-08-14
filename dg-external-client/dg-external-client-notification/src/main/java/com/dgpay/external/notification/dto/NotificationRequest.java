package com.dgpay.external.notification.dto;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
public class NotificationRequest {

    private String msg;
    private String target;

    public NotificationRequest(){

    }

    public NotificationRequest(String msg, String target){
        this.msg = msg;
        this.target = target;

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}




