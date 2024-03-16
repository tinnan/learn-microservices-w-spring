package com.example.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* This application is automatically a Eureka client
by having spring-cloud-starter-netflix-eureka-client is the classpath.
* */
@SpringBootApplication(scanBasePackages = {
        "com.example.customer",
        "com.example.amqp"
})
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
