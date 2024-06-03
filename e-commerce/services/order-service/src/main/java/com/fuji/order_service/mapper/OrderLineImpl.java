package com.fuji.order_service.mapper;

import com.fuji.order_service.dto.OrderLineRequest;
import com.fuji.order_service.dto.OrderLineResponse;
import com.fuji.order_service.entities.Order;
import com.fuji.order_service.entities.OrderLine;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderLineImpl implements OrderLineMapper{
    @Override
    public OrderLine mapToOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .order(
                        Order.builder()
                                .id(request.orderId())
                                .build()
                )
                .quantity(request.quantity())
                .productID(request.productID())
                .build();
    }

    @Override
    public OrderLineResponse mapToOrderLineResponse(OrderLine orderLine) {
        return null;
    }
}
