package com.targetindia.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class Address {
    @Column(name="address")
    private String streetAddress;
    private String city;
    private String region;
    @Column(name = "postal_code")
    private String postalCode;
    private String country;
}
