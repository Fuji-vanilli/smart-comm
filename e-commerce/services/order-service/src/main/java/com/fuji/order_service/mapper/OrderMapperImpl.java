package com.fuji.order_service.mapper;

import com.fuji.order_service.dto.OrderRequest;
import com.fuji.order_service.dto.OrderResponse;
import com.fuji.order_service.entities.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OrderMapperImpl implements OrderMapper {
    @Override
    public Order mapToOrder(OrderRequest request) {
        return Order.builder()
                .reference(request.reference())
                .customerId(request.customerID())
                .paymentMethod(request.paymentMethod())
                .build();
    }

    @Override
    public OrderResponse mapToOrderResponse(Order order) {
        return null;
    }
}
