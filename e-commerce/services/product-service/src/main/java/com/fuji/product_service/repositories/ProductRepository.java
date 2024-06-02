package com.fuji.product_service.repositories;

import com.fuji.product_service.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    boolean existsByName(String name);
    Optional<Product> findByName(String name);
    List<Product> findByIdInOrderById(List<String> idProducts);
}
