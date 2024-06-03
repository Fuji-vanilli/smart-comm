package com.fuji.order_service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(
        @NotNull(message = "product is mendatory")
        String productID,
        @Positive(message = "quantity does not negative")
        double quantity
) {}
