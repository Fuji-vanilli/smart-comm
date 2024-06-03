package com.fuji.order_service.model;

public record Address(
        String street,
        String city,
        String country,
        String houseNumber,
        String postalCode
) {
}
