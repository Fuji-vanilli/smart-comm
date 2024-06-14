package com.fuji.payment_service.dto;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String orderReference,
        BigDecimal amount,
        String customerFirstname,
        String customerLastname,
        String customerEmail
) {
}
