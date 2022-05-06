package com.example.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example.boot.Controller")
public class Boot05Web01Application {

    public static void main(String[] args) {
        SpringApplication.run(Boot05Web01Application.class, args);
    }

}
