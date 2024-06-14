package com.fuji.order_service.dto;

import com.fuji.order_service.model.PaymentMethod;

import java.math.BigDecimal;
import java.util.Date;

public record Payment(
        String id,
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Date createdDate,
        Date lastUpdateDate
) {
}
