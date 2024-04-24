package com.example.product;

import com.example.clients.customer.CustomerInfoResponse;
import com.example.clients.fraud.FraudCheckResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final OutboundAsyncWrapperService asyncWrapperService;

    public void applyProduct(Integer customerId, String productId) {
        try {
            final long startTs = System.currentTimeMillis();
            log.info("Invoke Get Customer Info API.");
            CompletableFuture<CustomerInfoResponse> customerInfoFuture = asyncWrapperService.getCustomerInfo(customerId);
            log.info("Invoke Get Is Fraudster API.");
            CompletableFuture<FraudCheckResponse> fraudsterFuture = asyncWrapperService.isFraudster(customerId);
            CompletableFuture.allOf(customerInfoFuture, fraudsterFuture).thenRun(() -> {
                long elapsed = System.currentTimeMillis() - startTs;
                log.info("Async API calls elapsed: {} ms", elapsed);
            });
            CustomerInfoResponse customerInfoResponse = customerInfoFuture.get();
            FraudCheckResponse fraudCheckResponse = fraudsterFuture.get();
            if (fraudCheckResponse.isFraudster()) {
                log.warn("The customer ID: {} is not eligible to apply for the product.", customerId);
            } else {
                // todo: implement actual save logic.
                log.info("Apply product {} for customer: {} {} successfully.", productId, customerInfoResponse.firstName(),
                    customerInfoResponse.lastName());
            }
        } catch (ExecutionException | InterruptedException e) {
            // todo: should handle exceptions from completable future.
            throw new RuntimeException(e);
        }
    }
}
