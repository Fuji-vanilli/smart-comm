package com.fuji.product_service.dto;

import com.fuji.product_service.entities.Product;

import java.util.List;

public record CategoryResponse(
        String id,
        String name,
        String description,
        List<Product> products
) { }
