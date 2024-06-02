package com.fuji.product_service.mapper;

import com.fuji.product_service.dto.ProductRequest;
import com.fuji.product_service.dto.ProductResponse;
import com.fuji.product_service.entities.Product;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductMapperImpl implements ProductMapper{
    @Override
    public Product mapToProduct(ProductRequest request) {
        return Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .availableQuantity(request.availableQuantity())
                .categoryID(request.categoryId())
                .build();
    }

    @Override
    public ProductResponse mapToProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory(),
                product.getCreateDate(),
                product.getLastUpdateDate()
        );
    }
}
