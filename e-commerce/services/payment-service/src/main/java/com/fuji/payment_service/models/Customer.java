package com.fuji.payment_service.models;

import lombok.*;

public record Customer(
        String firstname,
        String lastname,
        String email
) {
}
