package com.fuji.product_service.mapper;

import com.fuji.product_service.dto.ProductRequest;
import com.fuji.product_service.dto.ProductResponse;
import com.fuji.product_service.entities.Product;

public interface ProductMapper {
    Product mapToProduct(ProductRequest request);
    ProductResponse mapToProductResponse(Product product);
}
