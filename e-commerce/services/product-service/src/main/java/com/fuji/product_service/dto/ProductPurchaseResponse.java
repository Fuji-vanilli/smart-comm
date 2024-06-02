package com.fuji.product_service.dto;

import java.math.BigDecimal;

public record ProductPurchaseResponse (
    String id,
    String name,
    String description,
    double quantity,
    BigDecimal price
) {}
