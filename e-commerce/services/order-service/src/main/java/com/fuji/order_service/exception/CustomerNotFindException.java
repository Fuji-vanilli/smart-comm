package com.fuji.order_service.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFindException extends RuntimeException{
    private String message;

    public CustomerNotFindException(String message) {
        super(message);
    }
    public CustomerNotFindException(String message, Throwable cause) {
        super(message, cause);
    }
}
