package com.dgpay.persistence.sw.dao.customer;

import com.dgpay.persistence.sw.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
@Component
public class CustomerDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Customer selectByUid(Long uid){

//        jdbcTemplate.
        return null;
    }
}
