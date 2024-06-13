package com.fuji.order_service.kafka;

import com.fuji.order_service.model.Customer;
import com.fuji.order_service.model.PaymentMethod;
import com.fuji.order_service.model.ProductPurchaseRequest;
import com.fuji.order_service.model.ProductPurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String reference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<ProductPurchaseResponse> products
) {
}
