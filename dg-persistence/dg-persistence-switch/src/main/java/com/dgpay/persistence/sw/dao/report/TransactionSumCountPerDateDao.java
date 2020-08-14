package com.dgpay.persistence.sw.dao.report;

import com.dgpay.persistence.sw.model.report.TransactionSumCountPerDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
@Component
public class TransactionSumCountPerDateDao {


    String sqlCurrentDate = "select *\n" +
            "select q.pan,\n" +
            "       cus.UID                                             CUSTOMER_UID,\n" +
            "       c.UID                                               CARD_UID,\n" +
            "       q.CDATE,\n" +
            "       sum(case when r.IRESP = 0 then 1 else 0 end)        COUNNT_SUCCESS,\n" +
            "       sum(case when r.IRESP = 0 then 0 else 0 end)        COUNNT_UNSUCCESSFUL,\n" +
            "from TRANSACTION.REQUEST q,\n" +
            "     TRANSACTION.RESPONSE r,\n" +
            "     card.CARD c,\n" +
            "     COMMON.CUSTOMER cus\n" +
            "where q.TRNO = r.TRNO\n" +
            "  and q.cdate = :date\n" +
            "  and q.PAN = c.PAN\n" +
            "  and c.CUSTOMER_UID = cus.UID\n" +
            "  and q.pan = :pan\n" +
            "group by q.pan,\n" +
            "         cus.UID,\n" +
            "         c.UID,\n" +
            "         q.CDATE";


    String sqlCurrentDateAndOther = "select * from report.TRANSACTION_SUM_COUNT_PER_DATE where cdate between :dateFrom and :dateTo union all \n" +
            "select *\n" +
            "select q.pan,\n" +
            "       cus.UID                                             CUSTOMER_UID,\n" +
            "       c.UID                                               CARD_UID,\n" +
            "       q.CDATE,\n" +
            "       sum(case when r.IRESP = 0 then 1 else 0 end)        COUNNT_SUCCESS,\n" +
            "       sum(case when r.IRESP = 0 then 0 else 0 end)        COUNNT_UNSUCCESSFUL,\n" +
            "from TRANSACTION.REQUEST q,\n" +
            "     TRANSACTION.RESPONSE r,\n" +
            "     card.CARD c,\n" +
            "     COMMON.CUSTOMER cus\n" +
            "where q.TRNO = r.TRNO\n" +
            "  and q.cdate = :date\n" +
            "  and q.PAN = c.PAN\n" +
            "  and c.CUSTOMER_UID = cus.UID\n" +
            "  and q.pan = :pan\n" +
            "group by q.pan,\n" +
            "         cus.UID,\n" +
            "         c.UID,\n" +
            "         q.CDATE";

    String insert = "INSERT INTO REPORT.TRANSACTION_SUM_COUNT_PER_DATE (PAN, CUSTOMER_UID, CARD_UID, CDATE, COUNT_SUCCESS, COUNT_UNSUCCESSFUL) VALUES (" +
            "select *\n" +
            "select q.pan,\n" +
            "       cus.UID                                             CUSTOMER_UID,\n" +
            "       c.UID                                               CARD_UID,\n" +
            "       q.CDATE,\n" +
            "       sum(case when r.IRESP = 0 then 1 else 0 end)        COUNNT_SUCCESS,\n" +
            "       sum(case when r.IRESP = 0 then 0 else 0 end)        COUNNT_UNSUCCESSFUL,\n" +
            "from TRANSACTION.REQUEST q,\n" +
            "     TRANSACTION.RESPONSE r,\n" +
            "     card.CARD c,\n" +
            "     COMMON.CUSTOMER cus\n" +
            "where q.TRNO = r.TRNO\n" +
            "  and q.cdate = :date\n" +
            "  and q.PAN = c.PAN\n" +
            "  and c.CUSTOMER_UID = cus.UID\n" +
            "group by q.pan,\n" +
            "         cus.UID,\n" +
            "         c.UID,\n" +
            "         q.CDATE" +
            ");";


    String sqlDateBetween = "select * from report.TRANSACTION_SUM_COUNT_PER_DATE where cdate between :dateFrom and :dateTo and pan =:pan";


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;




    public List<TransactionSumCountPerDate> getDates(String dateFrom, Date dateTo, String currentDate, String pan) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("dateFrom", dateFrom)
                .addValue("dateTo", dateTo)
                .addValue("date", currentDate)
                .addValue("pan", pan);
        return jdbcTemplate.query(sqlDateBetween, namedParameters, new BeanPropertyRowMapper<>(TransactionSumCountPerDate.class));

    }

    public List<TransactionSumCountPerDate> getDateBetween(String dateFrom, String dateTo, String pan) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("dateFrom", dateFrom)
                .addValue("dateTo", dateTo)
                .addValue("pan", pan);
        return jdbcTemplate.query(sqlDateBetween, namedParameters, new BeanPropertyRowMapper<>(TransactionSumCountPerDate.class));

    }

    public List<TransactionSumCountPerDate> getCurrentDate(String currentDate, String pan) {

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("date", currentDate)
                .addValue("pan", pan);
        return jdbcTemplate.query(sqlCurrentDate, namedParameters, new BeanPropertyRowMapper<>(TransactionSumCountPerDate.class));

    }

    public void insertDaily(String currentDate) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("date", currentDate);
        jdbcTemplate.query(sqlCurrentDate, namedParameters, new BeanPropertyRowMapper<>(TransactionSumCountPerDate.class));
    }
}
