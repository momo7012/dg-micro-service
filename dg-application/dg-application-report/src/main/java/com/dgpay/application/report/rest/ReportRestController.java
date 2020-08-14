package com.dgpay.application.report.rest;

import com.dgpay.application.report.dto.ReportRequest;
import com.dgpay.persistence.sw.model.report.TransactionSumCountPerDate;
import com.dgpay.persistence.sw.servcie.report.TransactionSumCountPerDatePersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/13/2020
 */
@RestController
@RequestMapping("/report/v1/transaction")
public class ReportRestController {


    @Autowired
    private TransactionSumCountPerDatePersistenceService countPerDatePersistenceService;


    @PostMapping(value = "/getReport")
    public TransactionSumCountPerDate getReport(@RequestBody ReportRequest request) {

        TransactionSumCountPerDate countPerDateList = countPerDatePersistenceService.sumCount(request.getDateFrom(), request.getDateTo(), request.getPan());


        return countPerDateList;
    }
}
