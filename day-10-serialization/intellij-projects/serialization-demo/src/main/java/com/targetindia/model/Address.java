package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String city;
    private String state;
    private int pincode;

    public String toString(){
        return "%s, %s - %s%n".formatted(city, state, pincode);
    }

}
