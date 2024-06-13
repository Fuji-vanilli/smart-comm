package com.fuji.order_service.controllers;

import com.fuji.order_service.dto.OrderLineRequest;
import com.fuji.order_service.services.OrderLineService;
import com.fuji.order_service.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.fuji.order_service.utils.Root.APP_ROOT_ORDER_LINE;

@RestController
@RequestMapping(APP_ROOT_ORDER_LINE)
@RequiredArgsConstructor
public class OrderLineApi implements OrderLineController{
    private final OrderLineService orderLineService;
    @Override
    public ResponseEntity<Response> create(OrderLineRequest request) {
        return ResponseEntity.ok(orderLineService.create(request));
    }

    @Override
    public ResponseEntity<Response> udpate(OrderLineRequest request) {
        return ResponseEntity.ok(orderLineService.update(request));
    }

    @Override
    public ResponseEntity<Response> get(String idOrderLine) {
        return ResponseEntity.ok(orderLineService.get(idOrderLine));
    }

    @Override
    public ResponseEntity<Response> getAllByOrderId(String orderID) {
        return ResponseEntity.ok(orderLineService.getAllByOrderId(orderID));
    }

    @Override
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(orderLineService.getAll());
    }

    @Override
    public ResponseEntity<Response> delete(String idOrderLine) {
        return ResponseEntity.ok(orderLineService.delete(idOrderLine));
    }
}
