package com.fuji.payment_service.dto;

import com.fuji.payment_service.entity.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        String orderID,
        BigDecimal amount,
        PaymentMethod paymentMethod
) {
}
