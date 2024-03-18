package com.example.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/* This application is automatically a Eureka client
by having spring-cloud-starter-netflix-eureka-client is the classpath.
* */
@SpringBootApplication(scanBasePackages = {
        "com.example.customer",
        "com.example.amqp"
})
@EnableFeignClients(basePackages = "com.example.clients")
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
