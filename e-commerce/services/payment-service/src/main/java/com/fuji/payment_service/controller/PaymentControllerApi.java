package com.fuji.payment_service.controller;

import com.fuji.payment_service.dto.PaymentRequest;
import com.fuji.payment_service.services.PaymentService;
import com.fuji.payment_service.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.fuji.payment_service.utils.Root.APP_ROOT;


@RestController
@RequestMapping(APP_ROOT)
@RequiredArgsConstructor
public class PaymentControllerApi implements PaymentController{
    private final PaymentService paymentService;
    @Override
    public ResponseEntity<Response> create(PaymentRequest request) {
        return ResponseEntity.ok(paymentService.create(request));
    }

    @Override
    public ResponseEntity<Response> update(PaymentRequest request) {
        return ResponseEntity.ok(paymentService.update(request));
    }

    @Override
    public ResponseEntity<Response> get(String paymentID) {
        return ResponseEntity.ok(paymentService.get(paymentID));
    }

    @Override
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(paymentService.getAll());
    }

    @Override
    public ResponseEntity<Response> delete(String paymentID) {
        return ResponseEntity.ok(paymentService.delete(paymentID));
    }
}
