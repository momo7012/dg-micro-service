package com.dgpay.endpoint.payment.dto;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/13/2020
 */
public class TransferRequest {

    private String pan;
    private String destination;
    private String cvv2;
    private String expireDate;
    private String pin2;
    private Long amount;

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getPin2() {
        return pin2;
    }

    public void setPin2(String pin2) {
        this.pin2 = pin2;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}


