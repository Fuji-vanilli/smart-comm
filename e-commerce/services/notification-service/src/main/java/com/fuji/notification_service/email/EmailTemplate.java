package com.fuji.notification_service.email;

import lombok.Getter;

@Getter
public enum EmailTemplate {
    PAYMENT_CONFIRMATION("payment-confirmation.html", "Payment successfully processed"),
    ORDER_CONFIRMATION("order-confirmation.html", "Order successfully processed");

    private final String template;
    private final String subject;

    EmailTemplate(final String template, final String subject) {
        this.template = template;
        this.subject = subject;
    }
}
