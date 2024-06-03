package com.fuji.order_service.model;

public record Customer(
        String firstname,
        String lastname,
        String email,
        Address address
) {
}
