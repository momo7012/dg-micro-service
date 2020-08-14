package com.dgpay.persistence.sw.servcie.transaction;

import com.dgpay.persistence.sw.dao.transaction.RequestDao;
import com.dgpay.persistence.sw.model.transaction.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/14/2020
 */
@Service
public class RequestPersistenceService {


    @Autowired
    private RequestDao requestDao;

    public Long insertRequest(HashMap<String, Object> obj) {
        Request request = new Request();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
        request.setAmount((Long) obj.get("amount"));
        request.setPan((Long) obj.get("pan"));
        request.setPan2((Long) obj.get("pan2"));
        request.setCdate(Integer.valueOf(simpleDateFormat.format(date)));
        request.setCtime(new SimpleDateFormat("HHmmss").format(date));
        request.setReference_number((Long) obj.get("rrn"));

        return requestDao.insert(request);
    }
}
