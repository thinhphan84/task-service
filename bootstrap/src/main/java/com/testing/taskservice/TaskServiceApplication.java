package com.testing.taskservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.testing.taskservice.domain",
        "com.testing.taskservice.application",
        "com.testing.taskservice.infrastructure"
})
public class TaskServiceApplication {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(TaskServiceApplication.class, args);
    }

}
