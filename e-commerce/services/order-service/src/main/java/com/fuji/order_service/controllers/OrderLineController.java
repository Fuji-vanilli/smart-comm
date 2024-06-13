package com.fuji.order_service.controllers;

import com.fuji.order_service.dto.OrderLineRequest;
import com.fuji.order_service.utils.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface OrderLineController {
    @PostMapping("create")
    ResponseEntity<Response> create(
            @RequestBody @Valid OrderLineRequest request
    );
    @PutMapping("update")
    ResponseEntity<Response> udpate(
            @RequestBody @Valid OrderLineRequest request
    );
    @GetMapping("get/{idOrderLine}")
    ResponseEntity<Response> get(@PathVariable String idOrderLine);
    @GetMapping("getAllByOrderId/{orderID}")
    ResponseEntity<Response> getAllByOrderId(@PathVariable String orderID);
    @GetMapping("all")
    ResponseEntity<Response> getAll();
    @GetMapping("delete/{idOrderLine}")
    ResponseEntity<Response> delete(@PathVariable String idOrderLine);
}
