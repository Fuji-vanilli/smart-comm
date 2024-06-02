package com.fuji.product_service.controllers;

import com.fuji.product_service.dto.ProductPurchaseRequest;
import com.fuji.product_service.dto.ProductRequest;
import com.fuji.product_service.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductController {
    @PostMapping("create")
    ResponseEntity<Response> createProduct(@RequestBody ProductRequest product);
    @PutMapping("updated")
    ResponseEntity<Response> updateProduct(@RequestBody ProductRequest product);
    @GetMapping("get/{idProduct}")
    ResponseEntity<Response> get(@PathVariable String idProduct);
    @GetMapping("allProduct")
    ResponseEntity<Response> getAll();
    @DeleteMapping("delete/{idProduct}")
    ResponseEntity<Response> delete(@PathVariable String idProduct);
    @PatchMapping("purchase")
    ResponseEntity<Response> purchase(@RequestBody List<ProductPurchaseRequest> request);
}
