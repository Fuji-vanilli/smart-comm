package com.fuji.product_service.dto;

import com.fuji.product_service.entities.Category;

import java.math.BigDecimal;
import java.util.Date;

public record ProductResponse(
        String id,
        String name,
        String description,
        double quantity,
        BigDecimal price,
        Category category,
        Date createdDate,
        Date lastUpdateDate
) {
}
