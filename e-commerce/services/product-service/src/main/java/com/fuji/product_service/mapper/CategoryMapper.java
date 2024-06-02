package com.fuji.product_service.mapper;

import com.fuji.product_service.dto.CategoryRequest;
import com.fuji.product_service.dto.CategoryResponse;
import com.fuji.product_service.entities.Category;

public interface CategoryMapper {
    Category mapToCategory(CategoryRequest request);
    CategoryResponse mapToCategoryResponse(Category category);
}
