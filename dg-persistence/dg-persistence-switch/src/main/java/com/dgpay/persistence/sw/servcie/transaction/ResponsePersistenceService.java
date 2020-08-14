package com.dgpay.persistence.sw.servcie.transaction;

import com.dgpay.persistence.sw.dao.transaction.ResponseDao;
import com.dgpay.persistence.sw.model.transaction.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/14/2020
 */
@Service
public class ResponsePersistenceService {

    @Autowired
    private ResponseDao responseDao;

    public void insertResponse(Long trno, Integer resp) {
        Response response = new Response();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");

        response.setTrno(trno);
        response.setResp(resp);
        response.setCdate(Integer.valueOf(simpleDateFormat.format(date)));
        response.setCtime(new SimpleDateFormat("HHmmss").format(date));
        responseDao.insert(response);

    }
}
