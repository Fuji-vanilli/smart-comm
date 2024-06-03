package com.fuji.order_service.entities;

import com.fuji.order_service.model.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Order {
    @Id
    private String id;
    private String reference;
    private String customerId;
    private BigDecimal totalAmount;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;
    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @LastModifiedDate
    @Column(insertable = false)
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;
}
