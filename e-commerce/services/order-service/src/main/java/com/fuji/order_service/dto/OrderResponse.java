package com.fuji.order_service.dto;

import com.fuji.order_service.entities.OrderLine;
import com.fuji.order_service.model.PaymentMethod;

import java.util.Date;
import java.util.List;

public record OrderResponse(
        String orderId,
        String reference,
        String customerID,
        PaymentMethod paymentMethod,
        List<OrderLine> orderLines,
        Date createdDate,
        Date lastModifiedDate
) {
}
