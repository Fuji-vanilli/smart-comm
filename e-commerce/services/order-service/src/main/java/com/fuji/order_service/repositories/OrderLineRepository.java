package com.fuji.order_service.repositories;

import com.fuji.order_service.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, String> {
    List<OrderLine> findAllByOrderId(String orderId);
    boolean existsById(String orderLineId);
}
