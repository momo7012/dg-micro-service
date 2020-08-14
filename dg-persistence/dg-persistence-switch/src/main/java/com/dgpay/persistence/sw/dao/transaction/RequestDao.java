package com.dgpay.persistence.sw.dao.transaction;

import com.dgpay.persistence.sw.model.report.TransactionSumCountPerDate;
import com.dgpay.persistence.sw.model.transaction.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/14/2020
 */
@Component
public class RequestDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    String sqlInsert = "INSERT INTO TRANSACTION.REQUEST (AMOUNT, CDATE, PAN, PAN2, CTIME, REFERENCE_NUMBER) VALUES ( :AMOUNT, :CDATE, :PAN, :PAN2, :CTIME, :REFERENCE_NUMBER)";


    public Long insert(Request request) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("AMOUNT", request.getAmount())
                .addValue("CDATE", request.getCdate())
                .addValue("PAN", request.getPan())
                .addValue("PAN2", request.getPan2())
                .addValue("CTIME", request.getCtime())
                .addValue("REFERENCE_NUMBER", request.getReference_number());
        return jdbcTemplate.queryForObject(sqlInsert, namedParameters, new BeanPropertyRowMapper<>(Long.class));

    }
}
