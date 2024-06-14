package com.fuji.payment_service.controller;

import com.fuji.payment_service.dto.PaymentRequest;
import com.fuji.payment_service.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface PaymentController {
    @PostMapping("create")
    ResponseEntity<Response> create(@RequestBody PaymentRequest request);
    @PutMapping("update")
    ResponseEntity<Response> update(@RequestBody PaymentRequest request);
    @GetMapping("get/{paymentID}")
    ResponseEntity<Response> get(@PathVariable String paymentID);
    @GetMapping("all")
    ResponseEntity<Response> getAll();
    @DeleteMapping("delete/{paymentID}")
    ResponseEntity<Response> delete(@PathVariable String paymentID);
}
