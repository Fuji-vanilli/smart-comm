package com.fuji.product_service.services;

import com.fuji.product_service.dto.ProductPurchaseRequest;
import com.fuji.product_service.dto.ProductRequest;
import com.fuji.product_service.entities.Product;
import com.fuji.product_service.utils.Response;

import java.util.List;

public interface ProductService {
    Response createProduct(ProductRequest request);
    Response updateProduct(ProductRequest request);
    Response get(String idProduct);
    Response getAllProducts();
    Response delete(String idProduct);
    Response purchaseProduct(List<ProductPurchaseRequest> requests);
}
