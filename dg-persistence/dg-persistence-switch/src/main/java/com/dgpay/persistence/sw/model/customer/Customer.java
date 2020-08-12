package com.dgpay.persistence.sw.model.customer;

import java.util.Date;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
public class Customer {

    private Long uid;
    private String first_name;
    private String last_name;
    private String first_name_en;
    private String last_name_en;
    private String national_code;
    private String father_name;
    private String birth_date;
    private String id_number;
    private String passport_no;
    private String mobile_no;
    private Date insert_date;
    private Date modify_date;
    private Integer status;
    private String death_date;
    private Integer gender;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name_en() {
        return first_name_en;
    }

    public void setFirst_name_en(String first_name_en) {
        this.first_name_en = first_name_en;
    }

    public String getLast_name_en() {
        return last_name_en;
    }

    public void setLast_name_en(String last_name_en) {
        this.last_name_en = last_name_en;
    }

    public String getNational_code() {
        return national_code;
    }

    public void setNational_code(String national_code) {
        this.national_code = national_code;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getPassport_no() {
        return passport_no;
    }

    public void setPassport_no(String passport_no) {
        this.passport_no = passport_no;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDeath_date() {
        return death_date;
    }

    public void setDeath_date(String death_date) {
        this.death_date = death_date;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
