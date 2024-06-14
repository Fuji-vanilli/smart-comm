package com.fuji.payment_service.services;

import com.fuji.payment_service.dto.PaymentRequest;
import com.fuji.payment_service.mapper.PaymentMapper;
import com.fuji.payment_service.repository.PaymentRepository;
import com.fuji.payment_service.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public Response create(PaymentRequest request) {
        return null;
    }

    @Override
    public Response update(PaymentRequest request) {
        return null;
    }

    @Override
    public Response get(String paymentID) {
        return null;
    }

    @Override
    public Response getAll() {
        return null;
    }

    @Override
    public Response delete(String paymentID) {
        return null;
    }
}
