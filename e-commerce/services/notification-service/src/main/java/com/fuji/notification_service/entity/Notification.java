package com.fuji.notification_service.entity;

import com.fuji.notification_service.kafka.order.OrderConfirmation;
import com.fuji.notification_service.kafka.payment.PaymentConfirmation;
import com.fuji.notification_service.kafka.payment.PaymentMethod;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@Document(value = "notification")
public class Notification {
    @Id
    private String id;
    private NotificationType type;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;
    private LocalDateTime notificationDate;
}
