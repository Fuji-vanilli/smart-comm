package com.fuji.customer_service.utils;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Response {
    private LocalDateTime timeStamp;
    private HttpStatus status;
    private int statusCode;
    private Map<?, ?> data;
    private String message;
}
