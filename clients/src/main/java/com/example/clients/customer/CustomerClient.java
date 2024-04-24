package com.example.clients.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "customer"
        // Comment out URL because I want to use load balancing and Eureka service.
//        url = "${clients.customer.url}"
)
public interface CustomerClient {
    @PostMapping(path = "/api/v1/customers")
    CustomerRegistrationResponse registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest);
}
