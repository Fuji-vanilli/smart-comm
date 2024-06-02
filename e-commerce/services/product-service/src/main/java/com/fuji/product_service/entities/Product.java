package com.fuji.product_service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price;
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Temporal(TemporalType.DATE)
    private Date lastUpdateDate;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
