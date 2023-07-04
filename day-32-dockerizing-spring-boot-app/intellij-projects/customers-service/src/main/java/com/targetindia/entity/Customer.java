package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name")
    private String firstname;

    @Column(name="last_name")
    private String lastname;

    private String gender;
    private String email;
    private String phone;
    private String city;
}
