package com.fuji.product_service.mapper;

import com.fuji.product_service.dto.ProductPurchaseResponse;
import com.fuji.product_service.entities.Product;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductPurchaseMapperImpl implements ProductPurchaseMapper{
    @Override
    public ProductPurchaseResponse mapToProductPurchaseResponse(Product product, double quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                quantity,
                product.getPrice()
        );
    }
}
