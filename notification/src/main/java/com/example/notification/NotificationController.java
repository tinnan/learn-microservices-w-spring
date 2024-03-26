package com.example.notification;

import com.example.clients.notification.NotificationClient;
import com.example.clients.notification.NotificationInfoResponse;
import com.example.notification.data.NotificationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class NotificationController implements NotificationClient {

    private final NotificationRepository notificationRepository;

    @Override
    public NotificationInfoResponse getInfo() {
        Long count = notificationRepository.count();
        return new NotificationInfoResponse(count);
    }
}
