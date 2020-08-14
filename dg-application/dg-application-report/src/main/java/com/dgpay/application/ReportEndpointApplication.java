package com.dgpay.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/13/2020
 */
@SpringBootApplication
public class ReportEndpointApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ReportEndpointApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("***********************************************");
        System.out.println("*********Report Application is started*********");
        System.out.println("***********************************************");
    }
}
