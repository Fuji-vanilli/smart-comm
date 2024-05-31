package com.fuji.customer_service.mapper;

import com.fuji.customer_service.dto.CustomerRequest;
import com.fuji.customer_service.dto.CustomerResponse;
import com.fuji.customer_service.entities.Customer;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CustomerMapperImpl implements CustomerMapper{
    @Override
    public Customer mapToCustomer(CustomerRequest request) {
        return Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .address(request.address())
                .email(request.email())
                .build();
    }

    @Override
    public CustomerResponse mapToCustomerResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
