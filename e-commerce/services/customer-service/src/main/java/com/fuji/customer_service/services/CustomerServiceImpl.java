package com.fuji.customer_service.services;

import com.fuji.customer_service.dto.CustomerRequest;
import com.fuji.customer_service.mapper.CustomerMapper;
import com.fuji.customer_service.repositories.CustomerRepository;
import com.fuji.customer_service.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Response add(CustomerRequest request) {

        return null;
    }

    @Override
    public Response update(CustomerRequest request) {
        return null;
    }

    @Override
    public Response get(String customerId) {
        return null;
    }

    @Override
    public Response all() {
        return null;
    }

    @Override
    public Response delete(String customerId) {
        return null;
    }
    private Response generateResponse(HttpStatus status, URI location, Map<?, ?> data, String message) {
        return Response.builder()
                .timeStamp(LocalDateTime.now())
                .status(status)
                .location(location)
                .statusCode(status.value())
                .data(data)
                .message(message)
                .build();
    }
}
