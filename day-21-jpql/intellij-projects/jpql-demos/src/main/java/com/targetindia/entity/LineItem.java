package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "order_details")
public class LineItem implements Serializable {
    @Id
    @Column(name="order_id")
    private Integer orderId;
    @Id
    @Column(name="product_id")
    private Integer productId;
    @Column(name="unit_price")
    private Double unitPrice;
    @Column
    private Integer quantity;
    @Column
    private Double discount;

    @ManyToOne
    @JoinColumn(name="product_id", insertable = false, updatable = false)
    private Product product;
}
