package com.dgpay.persistence.notification.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/14/2020
 */
@Entity
@Table(name = "notification", schema = "notification")
public class Notification {

    @Id
    private Long uid;
    private String mobile;
    private String message;
    private Integer status;
    private Integer try_count;
    private Integer max_try;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTry_count() {
        return try_count;
    }

    public void setTry_count(Integer try_count) {
        this.try_count = try_count;
    }

    public Integer getMax_try() {
        return max_try;
    }

    public void setMax_try(Integer max_try) {
        this.max_try = max_try;
    }
}
