package com.fuji.product_service.mapper;

import com.fuji.product_service.dto.ProductPurchaseRequest;
import com.fuji.product_service.dto.ProductPurchaseResponse;
import com.fuji.product_service.entities.Product;

public interface ProductPurchaseMapper {
    ProductPurchaseResponse mapToProductPurchaseResponse(Product product, double quantity);
}
