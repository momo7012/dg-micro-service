package com.dgpay.persistence.sw.dao.card;

import com.dgpay.persistence.sw.model.card.Card;
import com.dgpay.persistence.sw.model.report.TransactionSumCountPerDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
@Component
public class CardDao {


    String sqlSelectCardByCusUid = "select * from card.card where customer_uid = :uid";
    String sqlDelete = "delete from card.card where customer_uid = :uid and pan=:pan";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Card> selectByCustomerUid(Long uid) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("uid", uid);
        return jdbcTemplate.query(sqlSelectCardByCusUid, namedParameters, new BeanPropertyRowMapper<>(Card.class));
    }

    public void insert(Card card) {
        // TODO: 8/13/2020 insert into card for new card
    }


    public void deleteCard(Long pan, Long customerNumber) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("uid", customerNumber)
                .addValue("pan", pan);
        jdbcTemplate.query(sqlSelectCardByCusUid, namedParameters, new BeanPropertyRowMapper<>(Card.class));
    }
}
