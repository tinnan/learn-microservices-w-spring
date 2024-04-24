package com.example.clients.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    name = "product"
)
public interface ProductClient {
    @PostMapping("/api/v1/product/apply")
    void apply(@RequestBody ApplyProductRequest applyProductRequest);
}
