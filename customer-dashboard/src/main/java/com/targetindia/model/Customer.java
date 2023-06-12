package com.targetindia.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Customer implements Serializable {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
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