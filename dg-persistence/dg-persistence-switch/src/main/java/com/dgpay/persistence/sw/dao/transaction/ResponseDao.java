package com.dgpay.persistence.sw.dao.transaction;

import com.dgpay.persistence.sw.model.transaction.Response;
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
public class ResponseDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    String sqlInsert = "INSERT INTO TRANSACTION.RESPONSE (TRNO, CDATE, IRESP,  CTIME) VALUES (:TRNO, :CDATE, :IRESP, :CTIME)";

    public void insert(Response response) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("TRNO", response.getTrno())
                .addValue("CDATE", response.getCdate())
                .addValue("IRESP", response.getResp())
                .addValue("CTIME", response.getCtime());
        jdbcTemplate.queryForObject(sqlInsert, namedParameters, new BeanPropertyRowMapper<>(Long.class));

    }
}
