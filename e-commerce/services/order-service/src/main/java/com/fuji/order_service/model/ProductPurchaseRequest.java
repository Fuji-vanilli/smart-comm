package com.fuji.order_service.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductPurchaseRequest(
        @NotNull(message = "id of product is mandatory")
        String productID,
        @Positive(message = "quantity does not negative")
        double quantity
) { }
