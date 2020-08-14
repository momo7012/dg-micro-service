package com.dgpay.application.payment.external.feign;

import feign.hystrix.FallbackFactory;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
public class Provider2ExternalFeignClientFallbackFactory implements FallbackFactory<Provider2ExternalFeignClient> {
    @Override
    public Provider2ExternalFeignClient create(Throwable cause) {
        return null;
    }
}
