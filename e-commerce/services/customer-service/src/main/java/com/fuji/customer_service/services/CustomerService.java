package com.fuji.customer_service.services;

import com.fuji.customer_service.dto.CustomerRequest;
import com.fuji.customer_service.utils.Response;

public interface CustomerService {
    Response add(CustomerRequest request);
    Response update(CustomerRequest request);
    Response get(String customerId);
    Response all();
    Response delete(String customerId);
}
