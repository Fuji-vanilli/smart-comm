package com.fuji.payment_service.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Builder
public class Payment {
    @Id
    private String id;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @NotNull(message = "customer id is required!")
    private String customerID;
    private String orderReference;
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Date createdDate;
    @LastModifiedDate
    @Column(nullable = false)
    private Date lastModifiedDate;
}
