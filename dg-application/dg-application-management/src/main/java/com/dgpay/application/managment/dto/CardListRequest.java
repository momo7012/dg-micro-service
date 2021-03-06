package com.dgpay.application.managment.dto;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/13/2020
 */
public class CardListRequest {

    private Long customerNumber;

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public String toString() {
        return "{" +
                "customerNumber=" + customerNumber +
                '}';
    }
}
