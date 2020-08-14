package com.dgpay.application.notification.external.feign;

import feign.hystrix.FallbackFactory;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
public class NotificationFeignClientFallbackFactory implements FallbackFactory<NotificationFeignClient> {
    @Override
    public NotificationFeignClient create(Throwable cause) {
        return null;
    }
}
