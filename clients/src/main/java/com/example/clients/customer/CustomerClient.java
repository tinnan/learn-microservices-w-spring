package com.example.clients.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "customer"
        // Comment out URL because I want to use load balancing and Eureka service.
//        url = "${clients.customer.url}"
)
public interface CustomerClient {
    @GetMapping("/api/v1/customers/{customerId}")
    CustomerInfoResponse getCustomerInfo(@PathVariable("customerId") Integer customerId);
    @PostMapping(path = "/api/v1/customers")
    CustomerRegistrationResponse registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest);
}
