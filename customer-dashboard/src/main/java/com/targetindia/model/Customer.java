package com.targetindia.model;

import lombok.Data;

import java.util.Date;

@Data
public class Customer {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private Date birthDate;
    private String city;
}