package com.fuji.customer_service.dto;

import com.fuji.customer_service.entities.Address;
import lombok.*;

public record CustomerResponse (
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {
}
