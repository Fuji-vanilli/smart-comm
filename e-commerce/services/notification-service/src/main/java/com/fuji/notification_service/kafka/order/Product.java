package com.fuji.notification_service.kafka.order;

import java.math.BigDecimal;

public record Product(
        String id,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
