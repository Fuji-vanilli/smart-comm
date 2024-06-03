package com.fuji.order_service.dto;

import com.fuji.order_service.entities.Order;

public  record OrderLineResponse(
        String id,
        Order order,
        double quantity
) { }
