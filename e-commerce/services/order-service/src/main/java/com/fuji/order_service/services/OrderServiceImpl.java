package com.fuji.order_service.services;

import com.fuji.order_service.dto.OrderRequest;
import com.fuji.order_service.repositories.OrderRepository;
import com.fuji.order_service.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Response create(OrderRequest request) {
        return null;
    }

    @Override
    public Response update(OrderRequest request) {
        return null;
    }

    @Override
    public Response get(String idOrder) {
        return null;
    }

    @Override
    public Response getAll() {
        return null;
    }

    @Override
    public Response delete(String idOrder) {
        return null;
    }
}
