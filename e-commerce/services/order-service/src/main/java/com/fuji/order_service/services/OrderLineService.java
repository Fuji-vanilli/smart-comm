package com.fuji.order_service.services;

import com.fuji.order_service.dto.OrderLineRequest;
import com.fuji.order_service.entities.OrderLine;
import com.fuji.order_service.utils.Response;

public interface OrderLineService {
    Response create(OrderLineRequest request);
    Response update(OrderLineRequest request);
    Response get(String idOrderLine);
    Response getAll();
    Response delete(String idOrderLine);
}
