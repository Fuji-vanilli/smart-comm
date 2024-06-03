package com.fuji.order_service.controllers;

import com.fuji.order_service.dto.OrderRequest;
import com.fuji.order_service.utils.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface OrderController {
    @PostMapping("create")
    ResponseEntity<Response> create(
            @RequestBody @Valid OrderRequest request
    );
    @PutMapping("update")
    ResponseEntity<Response> update(
            @RequestBody @Valid OrderRequest request
    );
    @GetMapping("get/{idOrder}")
    ResponseEntity<Response> get(@PathVariable String idOrder);
    @GetMapping("all")
    ResponseEntity<Response> getAll();
    @DeleteMapping("delete/{idOrder}")
    ResponseEntity<Response> delete(@PathVariable String idOrder);
}
