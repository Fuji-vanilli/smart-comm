package com.fuji.order_service.dto;

import com.fuji.order_service.entities.OrderLine;
import com.fuji.order_service.model.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

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
        @NotEmpty(message = "You should at least purchase one product")
        List<PurchaseRequest> products
) {
}
