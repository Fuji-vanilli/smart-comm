package com.fuji.order_service.dto;

import com.fuji.order_service.entities.OrderLine;
import com.fuji.order_service.model.PaymentMethod;
import com.fuji.order_service.model.ProductPurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
        @NotNull(message = "reference of order required!")
        String reference,
        @NotNull(message = "customer id of required!")
        @NotEmpty(message = "customer id of required!")
        @NotBlank(message = "customer id of required!")
        String customerID,
        @NotNull(message = "payment method required!")
        PaymentMethod paymentMethod,
        @Positive(message = "amount must be positive")
        @NotNull(message = "total amount required!")
        BigDecimal amount,
        @NotEmpty(message = "You should at least purchase one product")
        List<ProductPurchaseRequest> products
) {
}
