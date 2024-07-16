package com.fsse2406.eshopproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EshopProjectApplication {

    public static void main(String[] args) {


        Logger logger = LoggerFactory.getLogger(EshopProjectApplication.class);
        logger.info("hello welcome to connect to eshop database~~~!");

        SpringApplication.run(EshopProjectApplication.class, args);
    }

}
