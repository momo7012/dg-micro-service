package com.dgpay.persistence.sw.model.transaction;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
public class Response {

    private Long trno;
    private Integer cdate;
    private Integer resp;
    private Integer rtime;
    private String ctime;

    public Long getTrno() {
        return trno;
    }

    public void setTrno(Long trno) {
        this.trno = trno;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getCtime() {
        return ctime;
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

}
