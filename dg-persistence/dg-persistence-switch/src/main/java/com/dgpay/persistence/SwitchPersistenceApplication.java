package com.dgpay.persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 *
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
@SpringBootApplication
public class SwitchPersistenceApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SwitchPersistenceApplication.class, args);
    }

}
