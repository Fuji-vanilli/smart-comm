package com.fuji.payment_service.services;

import com.fuji.payment_service.dto.PaymentNotificationRequest;
import com.fuji.payment_service.dto.PaymentRequest;
import com.fuji.payment_service.entity.Payment;
import com.fuji.payment_service.mapper.PaymentMapper;
import com.fuji.payment_service.notification.NotificationProducer;
import com.fuji.payment_service.repository.PaymentRepository;
import com.fuji.payment_service.utils.Response;
import com.fuji.payment_service.webClient.WebClientCustomer;
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
    private final NotificationProducer notificationProducer;
    private final WebClientCustomer webClient;

    @Override
    public Response create(PaymentRequest request) {
        var payment = paymentMapper.mapToPayment(request);
        var customer= webClient.getCustomer(request.customerID());

        notificationProducer.sendNotification(new PaymentNotificationRequest(
                request.orderReference(),
                request.amount(),
                request.paymentMethod(),
                customer.firstname(),
                customer.lastname(),
                customer.email()
        ));

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
