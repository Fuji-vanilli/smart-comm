package com.fuji.order_service.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class OrderLineNotFoundException extends RuntimeException{
    private String message;

    public OrderLineNotFoundException(String message) {
        super(message);
    }
    public OrderLineNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
