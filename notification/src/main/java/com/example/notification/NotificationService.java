package com.example.notification;

import com.example.amqp.message.CustomerCreatedMessage;
import com.example.notification.data.MessageType;
import com.example.notification.data.Notification;
import com.example.notification.data.NotificationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void notifyCustomer(CustomerCreatedMessage customerCreated) {
        String message = "Hello " + customerCreated.email() + ", welcome to the community!";
        Notification notification = new Notification(UUID.randomUUID().toString(), LocalDateTime.now(),
                MessageType.NEW_CUSTOMER, message);
        notificationRepository.insert(notification);
        log.info("Notification sent.");
    }
}
