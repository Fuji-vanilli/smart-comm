package com.fuji.product_service.dto;

import com.fuji.product_service.entities.Product;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CategoryRequest(
        @NotNull(message = "name of category required!")
        String name,
        @NotNull(message = "description of category required!")
        String description,
        List<Product> products
) { }
