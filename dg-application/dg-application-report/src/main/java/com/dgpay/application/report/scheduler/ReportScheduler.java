package com.dgpay.application.report.scheduler;

import com.dgpay.persistence.sw.servcie.report.TransactionSumCountPerDatePersistenceService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/14/2020
 */
@Component
public class ReportScheduler {

    @Autowired
    private TransactionSumCountPerDatePersistenceService transactionSumCountPerDatePersistenceService;

    @Scheduled(cron = "0 0 * * *")
    public void process() {
        Date date = new Date();
        Date yesterday = DateUtils.addDays(date, -1);

        transactionSumCountPerDatePersistenceService.calcForDay(yesterday);


    }
}
