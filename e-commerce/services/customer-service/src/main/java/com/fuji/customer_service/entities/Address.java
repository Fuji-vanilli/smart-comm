package com.fuji.customer_service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Address {
    private String street;
    private String city;
    private String country;
    private String houseNumber;
    private String postalCode;
}
