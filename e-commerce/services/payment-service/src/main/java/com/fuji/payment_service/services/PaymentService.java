package com.fuji.payment_service.services;

import com.fuji.payment_service.dto.PaymentRequest;
import com.fuji.payment_service.utils.Response;

public interface PaymentService {
    Response create(PaymentRequest request);
    Response update(PaymentRequest request);
    Response get(String paymentID);
    Response getAll();
    Response delete(String paymentID);
}
