package com.example.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        try {
            Thread.sleep(2000); // Wait 2 secs.
            fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                    .customerId(customerId)
                    .isFraudster(false)
                    .createdAt(LocalDateTime.now())
                    .build());
            return false;
        } catch (InterruptedException e) {
            log.error("Thread.sleep interrupted.");
            throw new RuntimeException(e);
        }
    }
}
