package com.backend.Inventry_backend_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@EnableJpaAuditing
@EnableAsync
public class InventryBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventryBackendApplication.class, args);
        System.out.println("Application Started..");
    }
}
