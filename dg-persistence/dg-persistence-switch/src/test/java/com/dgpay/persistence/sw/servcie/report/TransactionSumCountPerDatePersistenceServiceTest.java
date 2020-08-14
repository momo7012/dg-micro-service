package com.dgpay.persistence.sw.servcie.report;

import com.dgpay.persistence.SwitchPersistenceApplication;
import com.dgpay.persistence.sw.model.report.TransactionSumCountPerDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/13/2020
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SwitchPersistenceApplication.class)
public class TransactionSumCountPerDatePersistenceServiceTest {

    @Autowired
    private TransactionSumCountPerDatePersistenceService transactionSumCountPerDatePersistenceService;

    @Test
    public void sumCount() {
        TransactionSumCountPerDate countPerDateList = transactionSumCountPerDatePersistenceService.sumCount("200811", "200812", "6037999332013381");

        assertTrue(countPerDateList.getCount_success() == 2);

    }
}