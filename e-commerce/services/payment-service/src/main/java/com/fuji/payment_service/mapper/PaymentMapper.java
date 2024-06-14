package com.fuji.payment_service.mapper;

import com.fuji.payment_service.dto.PaymentRequest;
import com.fuji.payment_service.dto.PaymentResponse;
import com.fuji.payment_service.entity.Payment;

public interface PaymentMapper {
    Payment mapToPayment(PaymentRequest request);
    PaymentResponse mapToPaymentResponse(Payment payment);
}
