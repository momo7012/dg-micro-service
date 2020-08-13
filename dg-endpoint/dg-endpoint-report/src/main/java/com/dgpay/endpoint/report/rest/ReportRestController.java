package com.dgpay.endpoint.report.rest;

import com.dgpay.endpoint.report.dto.ReportRequest;
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
    public List<TransactionSumCountPerDate> getReport(@RequestBody ReportRequest request) {

        List<TransactionSumCountPerDate> countPerDateList = countPerDatePersistenceService.sumCount(request.getDateFrom(), request.getDateTo());


        return countPerDateList;
    }
}
