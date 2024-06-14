package com.fuji.order_service.dto;

import com.fuji.order_service.model.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerID
) {
}
