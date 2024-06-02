package com.fuji.product_service.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductPurchaseException extends RuntimeException{
    private String message;

    public ProductPurchaseException(String message) {
        super(message);
    }
    public ProductPurchaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
