package com.example.product;

import com.example.clients.product.ApplyProductRequest;
import com.example.clients.product.ProductClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController implements ProductClient {

    private final ProductService productService;

    @Override
    public void apply(ApplyProductRequest applyProductRequest) {
        productService.applyProduct(applyProductRequest.customerId(), applyProductRequest.productId());
    }
}
