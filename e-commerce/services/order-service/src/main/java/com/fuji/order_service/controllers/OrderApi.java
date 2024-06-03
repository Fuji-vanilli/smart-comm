package com.fuji.order_service.controllers;

import com.fuji.order_service.dto.OrderRequest;
import com.fuji.order_service.services.OrderService;
import com.fuji.order_service.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.fuji.order_service.utils.Root.APP_ROOT_ORDER;

@RestController
@RequestMapping(APP_ROOT_ORDER)
@RequiredArgsConstructor
public class OrderApi implements OrderController{
    private final OrderService orderService;
    @Override
    public ResponseEntity<Response> create(OrderRequest request) {
        return ResponseEntity.ok(orderService.create(request));
    }

    @Override
    public ResponseEntity<Response> update(OrderRequest request) {
        return ResponseEntity.ok(orderService.update(request));
    }

    @Override
    public ResponseEntity<Response> get(String idOrder) {
        return ResponseEntity.ok(orderService.get(idOrder));
    }

    @Override
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @Override
    public ResponseEntity<Response> delete(String idOrder) {
        return ResponseEntity.ok(orderService.delete(idOrder));
    }
}
