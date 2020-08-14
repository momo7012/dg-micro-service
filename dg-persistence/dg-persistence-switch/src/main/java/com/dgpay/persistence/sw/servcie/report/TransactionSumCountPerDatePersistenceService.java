package com.dgpay.persistence.sw.servcie.report;

import com.dgpay.persistence.sw.dao.report.TransactionSumCountPerDateDao;
import com.dgpay.persistence.sw.model.report.TransactionSumCountPerDate;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
@Service
public class TransactionSumCountPerDatePersistenceService {

    @Autowired
    private TransactionSumCountPerDateDao transactionSumCountPerDateDao;


    public TransactionSumCountPerDate sumCount(String dateFrom, String dateTo, String pan) {

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
        String currentDate = simpleDateFormat.format(date);
        List<TransactionSumCountPerDate> countList = null;
        if (currentDate.equals(dateTo) && currentDate.equals(dateFrom)) {
            countList = transactionSumCountPerDateDao.getCurrentDate(currentDate, pan);
        } else if (currentDate.equals(dateTo)) {
            Date addDays = DateUtils.addDays(date, -1);
            countList = transactionSumCountPerDateDao.getDates(dateFrom, addDays, currentDate, pan);
        } else {
            countList = transactionSumCountPerDateDao.getDateBetween(dateFrom, dateTo, pan);
        }


        if (countList.size() > 1) {
            TransactionSumCountPerDate obj = new TransactionSumCountPerDate();
            obj.setCount_success(0L);
            obj.setCount_unsuccessful(0L);
            for (TransactionSumCountPerDate sumCountPerDate : countList) {
                obj.setCount_success(sumCountPerDate.getCount_success() + obj.getCount_success());
                obj.setCount_unsuccessful(sumCountPerDate.getCount_unsuccessful() + obj.getCount_success());
            }
            return obj;
        }

        return countList.get(0);
    }

    public void calcForDay(Date yesterday) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
        String currentDate = simpleDateFormat.format(yesterday);

        transactionSumCountPerDateDao.insertDaily(currentDate);
    }
}
