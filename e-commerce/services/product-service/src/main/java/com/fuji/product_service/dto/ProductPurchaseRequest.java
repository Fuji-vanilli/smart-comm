package com.fuji.product_service.dto;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
        @NotNull(message = "id of product is mandatory")
        String id,
        @NotNull(message = "quantity is mandatory")
        double quantity
) { }
