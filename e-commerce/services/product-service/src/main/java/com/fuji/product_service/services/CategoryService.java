package com.fuji.product_service.services;

import com.fuji.product_service.dto.CategoryRequest;
import com.fuji.product_service.utils.Response;

public interface CategoryService {
    Response create(CategoryRequest request);
    Response update(CategoryRequest request);
    Response get(String idCategory);
    Response getAllProducts();
    Response delete(String idCategory);
}
