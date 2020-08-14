package com.dgpay.application.payment.internal.feign;

import feign.hystrix.FallbackFactory;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
public class NotificationInternalFeignFallbackFactory implements FallbackFactory<NotificationInternalFeignClient> {
    @Override
    public NotificationInternalFeignClient create(Throwable cause) {
        return null;
    }
}
