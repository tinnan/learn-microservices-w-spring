package com.example.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "notification"
)
public interface NotificationClient {

    @GetMapping(path = "/api/v1/notification/info")
    NotificationInfoResponse getInfo();
}
