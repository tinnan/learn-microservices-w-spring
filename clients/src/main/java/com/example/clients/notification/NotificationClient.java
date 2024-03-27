package com.example.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "notification"
        // Comment out URL because I want to use load balancing and Eureka service.
//        url = "${clients.notification.url}"
)
public interface NotificationClient {

    @GetMapping(path = "/api/v1/notification/info")
    NotificationInfoResponse getInfo();
}
