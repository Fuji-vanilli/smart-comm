package com.fuji.order_service.dto;

import jakarta.validation.constraints.NotNull;

public record OrderLineRequest(
        @NotNull(message= "order id required!")
        String orderId,
        @NotNull(message = "product id required!")
        String productID,
        @NotNull(message = "quantity required!")
        double quantity
) {
}
