package com.fuji.customer_service.controllers;

import com.fuji.customer_service.dto.CustomerRequest;
import com.fuji.customer_service.services.CustomerService;
import com.fuji.customer_service.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.fuji.customer_service.utils.Root.APP_ROOT;


@RestController
@RequestMapping(APP_ROOT)
@RequiredArgsConstructor
public class CustomerApi implements CustomerController{
    private final CustomerService customerService;
    @Override
    public ResponseEntity<Response> add(CustomerRequest request) {
        return ResponseEntity.ok(customerService.add(request));
    }

    @Override
    public ResponseEntity<Response> update(CustomerRequest request) {
        return ResponseEntity.ok(customerService.update(request));
    }

    @Override
    public ResponseEntity<Response> get(String customerId) {
        return ResponseEntity.ok(customerService.get(customerId));
    }

    @Override
    public ResponseEntity<Response> all() {
        return ResponseEntity.ok(customerService.all());
    }

    @Override
    public ResponseEntity<Response> delete(String customerId) {
        return ResponseEntity.ok(customerService.delete(customerId));
    }
}
