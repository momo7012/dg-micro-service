package com.dgpay.endpoint.managment.dto;

import java.util.Date;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/13/2020
 */
public class AddCardResponse {

    private Long pan;
    private Date expire_date;
    private String pin;
    private String pin2;

    public Long getPan() {
        return pan;
    }

    public void setPan(Long pan) {
        this.pan = pan;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin2() {
        return pin2;
    }

    public void setPin2(String pin2) {
        this.pin2 = pin2;
    }
}
