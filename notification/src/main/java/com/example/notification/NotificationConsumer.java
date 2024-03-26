package com.example.notification;

import com.example.amqp.message.CustomerCreatedMessage;
import com.example.common.Global;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
public class NotificationConsumer {
    private final NotificationService notificationService;
    @RabbitListener(queues = Global.RABBIT_QUEUE_CUSTOMER)
    public void customerCreated(CustomerCreatedMessage message) {
        log.info("Customer created message: {}", message.toString());
        notificationService.notifyCustomer(message);
    }
}
