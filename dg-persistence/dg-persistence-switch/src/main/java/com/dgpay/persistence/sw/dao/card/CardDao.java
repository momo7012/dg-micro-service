package com.dgpay.persistence.sw.dao.card;

import com.dgpay.persistence.sw.model.card.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
@Component
public class CardDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Card> selectByCustomerUid(Long uid) {

        return null;
    }
}
