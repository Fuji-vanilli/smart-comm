package com.fuji.customer_service.dto;

import com.fuji.customer_service.entities.Address;
import lombok.*;

import java.util.Date;

public record CustomerResponse (
        String id,
        String firstname,
        String lastname,
        String email,
        Address address,
        Date createdDate,
        Date lastUpdateDate
) {
}
