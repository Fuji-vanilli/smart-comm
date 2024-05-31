package com.fuji.customer_service.repositories;

import com.fuji.customer_service.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    boolean existsByEmail(String email);
    void deleteByEmail(String email);
}
