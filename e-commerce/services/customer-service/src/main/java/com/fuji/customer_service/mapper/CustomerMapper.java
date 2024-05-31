package com.fuji.customer_service.mapper;

import com.fuji.customer_service.dto.CustomerRequest;
import com.fuji.customer_service.dto.CustomerResponse;
import com.fuji.customer_service.entities.Customer;

public interface CustomerMapper {
    Customer mapToCustomer(CustomerRequest request);
    CustomerResponse mapToCustomerResponse(Customer customer);
}
