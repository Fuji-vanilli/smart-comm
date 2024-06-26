package com.fuji.product_service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductPurchaseRequest(
        @NotNull(message = "id of product is mandatory")
        String id,
        @Positive(message = "quantity does not negative")
        double quantity
) { }
