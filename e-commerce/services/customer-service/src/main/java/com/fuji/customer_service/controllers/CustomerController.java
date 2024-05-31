package com.fuji.customer_service.controllers;

import com.fuji.customer_service.dto.CustomerRequest;
import com.fuji.customer_service.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CustomerController {
    @PostMapping("add")
    ResponseEntity<Response> add(@RequestBody CustomerRequest request);
    @PutMapping("update")
    ResponseEntity<Response> update(@RequestBody CustomerRequest request);
    @GetMapping("get/{customerId}")
    ResponseEntity<Response> get(@PathVariable String customerId);
    @GetMapping("all")
    ResponseEntity<Response> all();
    @DeleteMapping("delete/{customerId}")
    ResponseEntity<Response> delete(@PathVariable String customerId);
}
