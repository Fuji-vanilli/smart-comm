package com.fuji.product_service.controllers;

import com.fuji.product_service.dto.ProductPurchaseRequest;
import com.fuji.product_service.dto.ProductRequest;
import com.fuji.product_service.services.ProductService;
import com.fuji.product_service.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.fuji.product_service.utils.Root.APP_ROOT_PRODUCT;

@RestController
@RequestMapping(APP_ROOT_PRODUCT)
@RequiredArgsConstructor
public class ProductApi implements ProductController {
    private final ProductService productService;
    @Override
    public ResponseEntity<Response> createProduct(ProductRequest product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @Override
    public ResponseEntity<Response> updateProduct(ProductRequest product) {
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @Override
    public ResponseEntity<Response> get(String idProduct) {
        return ResponseEntity.ok(productService.get(idProduct));
    }

    @Override
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Override
    public ResponseEntity<Response> delete(String idProduct) {
        return ResponseEntity.ok(productService.delete(idProduct));
    }

    @Override
    public ResponseEntity<Response> purchase(List<ProductPurchaseRequest> request) {
        return ResponseEntity.ok(productService.purchaseProduct(request));
    }
}
