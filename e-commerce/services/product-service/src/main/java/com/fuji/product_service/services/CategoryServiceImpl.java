package com.fuji.product_service.services;

import com.fuji.product_service.dto.CategoryRequest;
import com.fuji.product_service.mapper.CategoryMapper;
import com.fuji.product_service.repositories.CategoryRepository;
import com.fuji.product_service.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Response create(CategoryRequest request) {
        return null;
    }

    @Override
    public Response update(CategoryRequest request) {
        return null;
    }

    @Override
    public Response get(String idCategory) {
        return null;
    }

    @Override
    public Response getAllProducts() {
        return null;
    }

    @Override
    public Response delete(String idCategory) {
        return null;
    }
}
