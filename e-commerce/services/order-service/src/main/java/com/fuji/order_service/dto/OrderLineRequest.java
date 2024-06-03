package com.fuji.order_service.dto;

import com.fuji.order_service.entities.Order;
import jakarta.validation.constraints.NotNull;

public record OrderLineRequest(
        @NotNull(message= "order required!")
        Order order,
        @NotNull(message = "product id required!")
        String productID,
        @NotNull(message = "quantity required!")
        double quantity
) {
}
