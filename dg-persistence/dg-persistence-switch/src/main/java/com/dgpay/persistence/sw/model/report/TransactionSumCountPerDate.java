package com.dgpay.persistence.sw.model.report;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
public class TransactionSumCountPerDate {


    private Long pan;
    private Long customer_uid;
    private Long card_uid;
    private Integer cdate;
    private Long count_success;
    private Long count_unsuccessful;

    public Long getPan() {
        return pan;
    }

    public void setPan(Long pan) {
        this.pan = pan;
    }

    public Long getCustomer_uid() {
        return customer_uid;
    }

    public void setCustomer_uid(Long customer_uid) {
        this.customer_uid = customer_uid;
    }

    public Long getCard_uid() {
        return card_uid;
    }

    public void setCard_uid(Long card_uid) {
        this.card_uid = card_uid;
    }

    public Integer getCdate() {
        return cdate;
    }

    public void setCdate(Integer cdate) {
        this.cdate = cdate;
    }

    public Long getCount_success() {
        return count_success;
    }

    public void setCount_success(Long count_success) {
        this.count_success = count_success;
    }

    public Long getCount_unsuccessful() {
        return count_unsuccessful;
    }

    public void setCount_unsuccessful(Long count_unsuccessful) {
        this.count_unsuccessful = count_unsuccessful;
    }

}
