package com.dgpay.endpoint.managment.dto;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/13/2020
 */
public class AddCardRequest {


    private Long customerNumber;

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }
}
