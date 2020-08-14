package com.dgpay.persistence.sw.model.card;

import java.util.Date;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
public class Card {

    private Long uid;
    private Long pan;
    private Integer issue_date;
    private Integer active_date;
    private Date expire_date;
    private Integer status;
    private Date insert_date;
    private Date modify_date;
    private Long customer_uid;
    private String pin;
    private Integer incorrect_pin1_try;
    private Integer incorrect_pin2_try;
    private Integer incorrect_cvv1_try;
    private Integer incorrect_cvv2_try;
    private String pin2;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getPan() {
        return pan;
    }

    public void setPan(Long pan) {
        this.pan = pan;
    }

    public Integer getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Integer issue_date) {
        this.issue_date = issue_date;
    }

    public Integer getActive_date() {
        return active_date;
    }

    public void setActive_date(Integer active_date) {
        this.active_date = active_date;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(Date insert_date) {
        this.insert_date = insert_date;
    }

    public Date getModify_date() {
        return modify_date;
    }

    public void setModify_date(Date modify_date) {
        this.modify_date = modify_date;
    }

    public Long getCustomer_uid() {
        return customer_uid;
    }

    public void setCustomer_uid(Long customer_uid) {
        this.customer_uid = customer_uid;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Integer getIncorrect_pin1_try() {
        return incorrect_pin1_try;
    }

    public void setIncorrect_pin1_try(Integer incorrect_pin1_try) {
        this.incorrect_pin1_try = incorrect_pin1_try;
    }

    public Integer getIncorrect_pin2_try() {
        return incorrect_pin2_try;
    }

    public void setIncorrect_pin2_try(Integer incorrect_pin2_try) {
        this.incorrect_pin2_try = incorrect_pin2_try;
    }

    public Integer getIncorrect_cvv1_try() {
        return incorrect_cvv1_try;
    }

    public void setIncorrect_cvv1_try(Integer incorrect_cvv1_try) {
        this.incorrect_cvv1_try = incorrect_cvv1_try;
    }

    public Integer getIncorrect_cvv2_try() {
        return incorrect_cvv2_try;
    }

    public void setIncorrect_cvv2_try(Integer incorrect_cvv2_try) {
        this.incorrect_cvv2_try = incorrect_cvv2_try;
    }

    public String getPin2() {
        return pin2;
    }

    public void setPin2(String pin2) {
        this.pin2 = pin2;
    }

    @Override
    public String toString() {
        return "Card{" +
                "uid=" + uid +
                ", pan=" + pan +
                ", issue_date=" + issue_date +
                ", active_date=" + active_date +
                ", expire_date=" + expire_date +
                ", status=" + status +
                ", insert_date=" + insert_date +
                ", modify_date=" + modify_date +
                ", customer_uid=" + customer_uid +
                ", pin='" + pin + '\'' +
                ", incorrect_pin1_try=" + incorrect_pin1_try +
                ", incorrect_pin2_try=" + incorrect_pin2_try +
                ", incorrect_cvv1_try=" + incorrect_cvv1_try +
                ", incorrect_cvv2_try=" + incorrect_cvv2_try +
                ", pin2='" + pin2 + '\'' +
                '}';
    }
}
