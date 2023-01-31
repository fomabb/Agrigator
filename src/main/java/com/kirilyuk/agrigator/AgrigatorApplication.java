package com.kirilyuk.agrigator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AgrigatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgrigatorApplication.class, args);
    }
}
