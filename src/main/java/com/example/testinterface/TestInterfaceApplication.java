package com.example.testinterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.*")
public class TestInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestInterfaceApplication.class, args);

        
    }

}
