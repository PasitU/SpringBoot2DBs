package com.example.thisbetterwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.thisbetterwork.repositories", "com.example.thisbetterwork.repositories2"})
public class ThisBetterWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThisBetterWorkApplication.class, args);
    }

}
