package com.targetindia.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Person {
    private String name;
    private String city;
    private String email;

    public Person(){
        // a constructor can be called only from another constructor
        this(null, "Mysore", null);
    }

    public Person(String name, String city, String email) {
        this.name = name;
        this.city = city;
        this.email = email;
    }

    public void print(){
        System.out.printf("Name     = %s%n", name);
        System.out.printf("City     = %s%n", city);
        System.out.printf("Email    = %s%n", email);
    }

}
