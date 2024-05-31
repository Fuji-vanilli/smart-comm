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
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Response add(CustomerRequest request) {
        if (customerRepository.existsByEmail(request.email())) {
            log.error("customer already exist into the database");
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    "customer already exist into the database"
            );
        }

        var customer= customerMapper.mapToCustomer(request);
        customer.setId(UUID.randomUUID().toString());
        customer.setCreatedDate(new Date());
        customer.setLastUpdateDate(new Date());

        customerRepository.save(customer);
        log.info("new customer added successfully!");

        return generateResponse(
                HttpStatus.OK,
                Map.of(
                        "customer", customerMapper.mapToCustomerResponse(customer)
                ),
                "new customer added successfully!"
        );
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
    private Response generateResponse(HttpStatus status, Map<?, ?> data, String message) {
        return Response.builder()
                .timeStamp(LocalDateTime.now())
                .status(status)
                .statusCode(status.value())
                .data(data)
                .message(message)
                .build();
    }
}
