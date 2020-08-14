package com.dgpay.application.payment.external.service;

import java.util.HashMap;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/14/2020
 */
public interface ProviderService {
    public boolean process(HashMap<String, Object> holder);
}
