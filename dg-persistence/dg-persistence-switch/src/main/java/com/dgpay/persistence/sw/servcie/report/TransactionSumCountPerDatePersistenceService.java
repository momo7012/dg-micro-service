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


    public List<TransactionSumCountPerDate> sumCount(String dateFrom, String dateTo, String pan) {

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

        return countList;
    }
}
