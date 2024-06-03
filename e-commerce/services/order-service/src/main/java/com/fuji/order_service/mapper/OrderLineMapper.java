package com.fuji.order_service.mapper;

import com.fuji.order_service.dto.OrderLineRequest;
import com.fuji.order_service.dto.OrderLineResponse;
import com.fuji.order_service.entities.Order;
import com.fuji.order_service.entities.OrderLine;

public interface OrderLineMapper {
    OrderLine mapToOrderLine(OrderLineRequest request);
    OrderLineResponse mapToOrderLineResponse(OrderLine orderLine);
}
