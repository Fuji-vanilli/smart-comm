package com.fuji.customer_service.dto;

import com.fuji.customer_service.entities.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        @NotNull(message = "firstname is required")
        String firstname,
        @NotNull(message = "lastname is required")
        String lastname,
        @NotNull(message = "email is required")
        @Email(message = "email format not valid")
        String email,
        Address address
) {}
