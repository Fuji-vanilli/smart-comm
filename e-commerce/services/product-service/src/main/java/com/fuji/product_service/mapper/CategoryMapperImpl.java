package com.fuji.product_service.mapper;

import com.fuji.product_service.dto.CategoryRequest;
import com.fuji.product_service.dto.CategoryResponse;
import com.fuji.product_service.entities.Category;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryMapperImpl implements CategoryMapper{
    @Override
    public Category mapToCategory(CategoryRequest request) {
        return Category.builder()
                .name(request.name())
                .description(request.description())
                .products(request.products())
                .build();
    }

    @Override
    public CategoryResponse mapToCategoryResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getProducts(),
                category.getCreatedDate(),
                category.getLastUpdatedDate()
        );
    }
}
