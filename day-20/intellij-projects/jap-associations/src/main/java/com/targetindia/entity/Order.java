package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "required_date")
    private Date requiredDate;
    @Column(name = "shipped_date")
    private Date shippedDate;

    @ManyToOne
    @JoinColumn(name="ship_via")
    private Shipper shipper;

    @Column
    private Double freight;

    @Column(name = "ship_name")
    private String shipToName;
}
