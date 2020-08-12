package com.dgpay.persistence.sw.servcie.customer;

import com.dgpay.persistence.sw.dao.customer.CustomerDao;
import com.dgpay.persistence.sw.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
@Service
public class CustomerPersistenceService {

    @Autowired
    private CustomerDao customerDao;

    public void getCustomer(Long uid){


        Customer customer = customerDao.selectByUid(uid);
    }
}
