package com.fuji.product_service.controllers;

import com.fuji.product_service.dto.CategoryRequest;
import com.fuji.product_service.services.CategoryService;
import com.fuji.product_service.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.fuji.product_service.utils.Root.APP_ROOT_CATEGORY;

@RestController
@RequestMapping(APP_ROOT_CATEGORY)
@RequiredArgsConstructor
public class CategoryApi implements CategoryController{
    private final CategoryService categoryService;
    @Override
    public ResponseEntity<Response> create(CategoryRequest request) {
        return ResponseEntity.ok(categoryService.create(request));
    }

    @Override
    public ResponseEntity<Response> update(CategoryRequest request) {
        return ResponseEntity.ok(categoryService.update(request));
    }

    @Override
    public ResponseEntity<Response> get(String idCategory) {
        return ResponseEntity.ok(categoryService.get(idCategory));
    }

    @Override
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(categoryService.getAllProducts());
    }

    @Override
    public ResponseEntity<Response> delete(String idCategory) {
        return ResponseEntity.ok(categoryService.delete(idCategory));
    }
}
