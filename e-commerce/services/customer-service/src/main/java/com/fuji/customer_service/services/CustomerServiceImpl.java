package com.fuji.customer_service.services;

import com.fuji.customer_service.dto.CustomerRequest;
import com.fuji.customer_service.dto.CustomerResponse;
import com.fuji.customer_service.entities.Customer;
import com.fuji.customer_service.exceptions.CustomerNotFoundException;
import com.fuji.customer_service.mapper.CustomerMapper;
import com.fuji.customer_service.repositories.CustomerRepository;
import com.fuji.customer_service.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.*;

import static java.lang.String.format;

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
        var customer= customerRepository.findByEmail(request.email())
                .orElseThrow(()-> new CustomerNotFoundException(
                        format("Can't update customer:: No customer found with the ID:: %s", request.email()
                        )
                ));

        mergerCustomer(customer, request);
        customer.setLastUpdateDate(new Date());

        customerRepository.save(customer);
        log.info("customer updated successfully!");

        return generateResponse(
                HttpStatus.OK,
                Map.of(
                        "customer", customerMapper.mapToCustomerResponse(customer)
                ),
                "customer updated successfully!"
        );
    }

    private void mergerCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstname())) {
            customer.setFirstname(request.firstname());
        }
        if (StringUtils.isNotBlank(request.lastname())) {
            customer.setLastname(request.lastname());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (!Objects.isNull(request.address())) {
            customer.setAddress(request.address());
        }
    }

    @Override
    public Response get(String customerId) {
        var customer= customerRepository.findByEmail(customerId);
        if (customer.isEmpty()) {
            log.error("customer doesn't exist into the database");
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    "customer doesn't exist into the database"
            );
        }

        log.info("customer finded successfully!");
        return generateResponse(
                HttpStatus.OK,
                Map.of(
                        "customer", customerMapper.mapToCustomerResponse(customer.get())
                ),
                "customer finded successfully!"
        );
    }

    @Override
    public Response all() {
        List<Customer> allCustomers = customerRepository.findAll();
        if (allCustomers.isEmpty()) {
            log.error("empty customer from database");
            return generateResponse(
                    HttpStatus.NO_CONTENT,
                    null,
                    "empty customer from database"
            );
        }
        return generateResponse(
                HttpStatus.OK,
                Map.of(
                        "customers", allCustomers.stream()
                                .map(customerMapper::mapToCustomerResponse)
                                .toList()
                ),
                "all customers finded successfully!"
        );
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
