package com.fuji.order_service.repositories;

import com.fuji.order_service.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, String> {
}
