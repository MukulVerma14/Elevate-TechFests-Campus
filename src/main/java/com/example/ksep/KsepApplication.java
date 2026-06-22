package com.example.ksep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class KsepApplication {
    public static void main(String[] args) {
        SpringApplication.run(KsepApplication.class, args);
    }
}
