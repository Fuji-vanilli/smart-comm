package com.fuji.payment_service.mapper;

import com.fuji.payment_service.dto.PaymentRequest;
import com.fuji.payment_service.dto.PaymentResponse;
import com.fuji.payment_service.entity.Payment;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public Payment mapToPayment(PaymentRequest request) {
        return Payment.builder()
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .orderReference(request.orderReference())
                .customerID(request.customerID())
                .build();
    }

    @Override
    public PaymentResponse mapToPaymentResponse(Payment payment) {
        return new PaymentResponse(
                payment.getId(),
                payment.getOrderReference(),
                payment.getAmount(),
                payment.getPaymentMethod(),
                payment.getCreatedDate(),
                payment.getLastModifiedDate()
        );
    }
}
