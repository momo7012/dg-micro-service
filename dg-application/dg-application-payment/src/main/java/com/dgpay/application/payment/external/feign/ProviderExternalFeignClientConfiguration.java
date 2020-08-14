package com.dgpay.application.payment.external.feign;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */

public class ProviderExternalFeignClientConfiguration {

    @Bean
    public ErrorDecoder cardClientErrorDecoder() {
        return new ErrorDecoder.Default() {

        };
    }
}
