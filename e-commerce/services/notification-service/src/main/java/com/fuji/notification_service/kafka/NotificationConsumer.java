package com.fuji.notification_service.kafka;

import com.fuji.notification_service.email.EmailService;
import com.fuji.notification_service.entity.Notification;
import com.fuji.notification_service.entity.NotificationType;
import com.fuji.notification_service.kafka.order.OrderConfirmation;
import com.fuji.notification_service.kafka.payment.PaymentConfirmation;
import com.fuji.notification_service.kafka.payment.PaymentMethod;
import com.fuji.notification_service.repositories.NotificationRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationConsumer {
    private final NotificationRepository notificationRepository;
    private EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentConfirmationNotification(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info(format("Consume message from the payment-topic Topic ::%s", paymentConfirmation));

        notificationRepository.save(
                Notification.builder()
                        .type(NotificationType.PAYMENT_CONFIRMATION)
                        .paymentConfirmation(paymentConfirmation)
                        .notificationDate(LocalDateTime.now())
                        .build()
        );

        emailService.sentPaymentSuccessEmail(paymentConfirmation);
    }

    @KafkaListener(topics = "order-topic")
    public void consumerOrderConfirmationNotification(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info(format("Consume message from the order-topic Topic ::%s", orderConfirmation));

        notificationRepository.save(
                Notification.builder()
                        .type(NotificationType.ORDER_CONFIRMATION)
                        .orderConfirmation(orderConfirmation)
                        .notificationDate(LocalDateTime.now())
                        .build()
        );

        emailService.sentOrderConfirmationEmail(orderConfirmation);
    }
}
