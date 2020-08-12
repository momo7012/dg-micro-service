package com.dgpay.persistence.sw.model.transaction;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
public class Response {

    private Integer trno;
    private Integer cdate;
    private Integer resp;
    private Integer rtime;
    private Integer ctime;

    public Integer getTrno() {
        return trno;
    }

    public void setTrno(Integer trno) {
        this.trno = trno;
    }

    public Integer getCdate() {
        return cdate;
    }

    public void setCdate(Integer cdate) {
        this.cdate = cdate;
    }

    public Integer getResp() {
        return resp;
    }

    public void setResp(Integer resp) {
        this.resp = resp;
    }

    public Integer getRtime() {
        return rtime;
    }

    public void setRtime(Integer rtime) {
        this.rtime = rtime;
    }

    public Integer getCtime() {
        return ctime;
    }

    public void setCtime(Integer ctime) {
        this.ctime = ctime;
    }
}
