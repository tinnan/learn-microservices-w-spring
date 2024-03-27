package com.example.customer;

import com.example.clients.customer.CustomerClient;
import com.example.clients.customer.CustomerRegistrationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class CustomerController implements CustomerClient {

    private final CustomerService customerService;

    @Override
    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        log.info("new customer registration {}", customerRequest);
        customerService.registerCustomer(customerRequest);
    }
}
