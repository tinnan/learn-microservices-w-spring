package com.example.customer;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {

    @Bean
    @LoadBalanced // In service discovery, this annotation enables Application name look up (instead of hostname and
    // port) in request URI
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
