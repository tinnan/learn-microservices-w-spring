package com.example.product;

import com.example.clients.customer.CustomerClient;
import com.example.clients.customer.CustomerInfoResponse;
import com.example.clients.fraud.FraudCheckResponse;
import com.example.clients.fraud.FraudClient;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OutboundAsyncWrapperService {
    private final CustomerClient customerClient;
    private final FraudClient fraudClient;

    @Async
    public CompletableFuture<CustomerInfoResponse> getCustomerInfo(Integer customerId) {
        CustomerInfoResponse customerInfoResponse = customerClient.getCustomerInfo(customerId);
        return CompletableFuture.completedFuture(customerInfoResponse);
    }

    @Async
    public CompletableFuture<FraudCheckResponse> isFraudster(Integer customerId) {
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customerId);
        return CompletableFuture.completedFuture(fraudCheckResponse);
    }
}
