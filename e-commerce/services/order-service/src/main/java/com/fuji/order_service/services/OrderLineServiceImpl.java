package com.fuji.order_service.services;

import com.fuji.order_service.dto.OrderLineRequest;
import com.fuji.order_service.repositories.OrderLineRepository;
import com.fuji.order_service.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {
    private final OrderLineRepository orderLineRepository;
    @Override
    public Response create(OrderLineRequest request) {
        return null;
    }

    @Override
    public Response update(OrderLineRequest request) {
        return null;
    }

    @Override
    public Response get(String idOrderLine) {
        return null;
    }

    @Override
    public Response getAll() {
        return null;
    }

    @Override
    public Response delete(String idOrderLine) {
        return null;
    }
}
