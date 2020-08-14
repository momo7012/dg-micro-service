package com.dgpay.persistence.sw.dao.customer;

import com.dgpay.persistence.sw.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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

    String sqlSelect = "select * from COMMON.CUSTOMER where UID = :uid";

    public Customer selectByUid(Long uid) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("uid", uid);
        return jdbcTemplate.queryForObject(sqlSelect, namedParameters, new BeanPropertyRowMapper<>(Customer.class));
    }
}
