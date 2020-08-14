package com.dgpay.persistence.sw.model.transaction;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
public class Request {

    private Long trno;
    private Long amount;
    private Integer cdate;
    private Long pan;
    private Long pan2;
    private String ctime;
    private Long reference_number;

    public Long getTrno() {
        return trno;
    }

    public void setTrno(Long trno) {
        this.trno = trno;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getCdate() {
        return cdate;
    }

    public void setCdate(Integer cdate) {
        this.cdate = cdate;
    }

    public Long getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public Long getPan2() {
        return pan2;
    }

    public void setPan2(Long pan2) {
        this.pan2 = pan2;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public Long getReference_number() {
        return reference_number;
    }

    public void setReference_number(Long reference_number) {
        this.reference_number = reference_number;
    }
}
