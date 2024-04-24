package com.example.customer;

import com.example.clients.customer.CustomerClient;
import com.example.clients.customer.CustomerInfoResponse;
import com.example.clients.customer.CustomerRegistrationRequest;
import com.example.clients.customer.CustomerRegistrationResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class CustomerController implements CustomerClient {

    private final CustomerService customerService;

    @Override
    public CustomerInfoResponse getCustomerInfo(Integer customerId) {
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            return null;
        }
        return new CustomerInfoResponse(customer.getId(), customer.getFirstName(), customer.getLastName(),
            customer.getEmail());
    }

    @Override
    public CustomerRegistrationResponse registerCustomer(CustomerRegistrationRequest customerRequest) {
        log.info("new customer registration {}", customerRequest);
        Customer customer = customerService.registerCustomer(customerRequest);
        return new CustomerRegistrationResponse(customer.getId());
    }
}
