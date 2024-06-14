package com.fuji.payment_service.dto;

import com.fuji.payment_service.entity.PaymentMethod;

import java.math.BigDecimal;
import java.util.Date;

public record PaymentResponse(
        String id,
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Date createdDate,
        Date lastUpdateDate
) {
}
