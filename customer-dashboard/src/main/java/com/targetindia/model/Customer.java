package com.targetindia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="customers")
@Data
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="first_name")
    private String firstname;
    @Column(name="last_name")
    private String lastname;
    private String email;
    private String phone;
    @Column(name="birth_date")
    private Date birthDate;
    private String city;
}

/*
create table customers(
    id int primary key auto_increment,
    first_name varchar(25) not null,
    last_name varchar(25),
    email varchar(200) unique,
    phone varchar(15) unique,
    birth_date date,
    city varchar(50) default 'Bangalore'
)
*/