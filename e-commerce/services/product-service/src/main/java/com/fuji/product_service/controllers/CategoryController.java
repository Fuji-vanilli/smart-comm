package com.fuji.product_service.controllers;

import com.fuji.product_service.dto.CategoryRequest;
import com.fuji.product_service.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CategoryController {
    @PostMapping("create")
    ResponseEntity<Response> create(@RequestBody CategoryRequest request);
    @PutMapping("update")
    ResponseEntity<Response> update(@RequestBody CategoryRequest request);
    @GetMapping("get/{idCategory}")
    ResponseEntity<Response> get(@PathVariable String idCategory);
    @GetMapping("all")
    ResponseEntity<Response> getAll();
    @DeleteMapping("delete/{idCategory}")
    ResponseEntity<Response> delete(@PathVariable String idCategory);
}
