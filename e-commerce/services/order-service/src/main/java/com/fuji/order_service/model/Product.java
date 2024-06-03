package com.fuji.order_service.model;

import java.math.BigDecimal;
import java.util.Date;

public record Product (
    String name,
    String description,
    double quantity,
    BigDecimal price,
    Category category,
    Date createdDate,
    Date lastUpdateDate
) {}
