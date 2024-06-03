package com.fuji.order_service.mapper;

import com.fuji.order_service.dto.OrderRequest;
import com.fuji.order_service.dto.OrderResponse;
import com.fuji.order_service.entities.Order;

public interface OrderMapper {
    Order mapToOrder(OrderRequest request);
    OrderResponse mapToOrderResponse(Order order);
}
