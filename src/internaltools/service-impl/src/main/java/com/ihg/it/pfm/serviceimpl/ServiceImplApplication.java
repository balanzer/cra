package com.ihg.it.pfm.serviceimpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ihg.it.pfm")
public class ServiceImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceImplApplication.class, args);
    }
}
