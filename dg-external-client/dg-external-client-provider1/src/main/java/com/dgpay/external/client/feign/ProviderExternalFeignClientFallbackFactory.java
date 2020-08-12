package com.dgpay.external.client.feign;

import feign.hystrix.FallbackFactory;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
public class ProviderExternalFeignClientFallbackFactory implements FallbackFactory<ProviderExternalFeignClient> {
    @Override
    public ProviderExternalFeignClient create(Throwable cause) {
        return null;
    }
}
