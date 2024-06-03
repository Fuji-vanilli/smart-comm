package com.fuji.order_service.repositories;

import com.fuji.order_service.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, String> {
    Optional<Order> findByReference(String reference);
    void deleteByReference(String reference);
    boolean existsByReference(String reference);
}
