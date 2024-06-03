package com.fuji.order_service.services;

import com.fuji.order_service.dto.OrderRequest;
import com.fuji.order_service.utils.Response;

public interface OrderService {
    Response create(OrderRequest request);
    Response update(OrderRequest request);
    Response get(String idOrder);
    Response getAll();
    Response delete(String idOrder);
}
