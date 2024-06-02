package com.fuji.product_service.dto;

import com.fuji.product_service.entities.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record ProductRequest (
        @NotNull(message = "name of product required!")
        String name,
        String description,
        @Positive(message = "quantity of product must be positive")
        double availableQuantity,
        @Positive(message = "price of product must be positive" )
        BigDecimal price,
        @NotNull(message= "category id of the product is required!")
        String categoryId
) { }
