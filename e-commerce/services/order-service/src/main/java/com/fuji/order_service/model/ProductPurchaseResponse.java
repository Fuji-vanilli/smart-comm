package com.fuji.order_service.model;

import java.math.BigDecimal;

public record ProductPurchaseResponse (
    String id,
    String name,
    String description,
    double quantity,
    BigDecimal price
) {}
