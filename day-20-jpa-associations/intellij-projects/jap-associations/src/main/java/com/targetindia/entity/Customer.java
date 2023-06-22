package com.targetindia.entity;

import com.targetindia.model.Address;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name="customer_id")
    private String customerId;
    @Column(name="company_name")
    private String companyName;
    @Column(name="contact_name")
    private String contactName;
    @Column(name="contact_title")
    private String contactTitle;

    @Embedded
    private Address address; // has 5 properties that correspond to 5 columns of suppliers table

    @Column
    private String phone;
    @Column
    private String fax;

    @OneToMany
    @JoinColumn(name="customer_id")
    private List<Order> orders;
}
