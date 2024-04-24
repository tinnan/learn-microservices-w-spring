package com.example.customer;

import com.example.amqp.RabbitMQMessageProducer;
import com.example.amqp.message.CustomerCreatedMessage;
import com.example.clients.customer.CustomerRegistrationRequest;
import com.example.clients.fraud.FraudCheckResponse;
import com.example.clients.fraud.FraudClient;
import com.example.common.Global;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public Customer getCustomer(Integer id) {
        try {
            Thread.sleep(3000);
            return customerRepository.findById(id).orElse(null);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer
                .builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        // todo: check if email valid, not taken
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(
                customer.getId());

        if (fraudCheckResponse != null && fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
        // todo: send notification
        rabbitMQMessageProducer.publish(new CustomerCreatedMessage(customer.getId(), customer.getEmail()), Global.RABBIT_EXCHANGE,
                "created");
        return customer;
    }
}
