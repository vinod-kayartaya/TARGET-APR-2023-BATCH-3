package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    private int id;
    private String name;
    private double salary;
    public void print(){
        System.out.printf("Id        : %d%n", id);
        System.out.printf("Name      : %s%n", name);
        System.out.printf("Salary    : %.2f%n", salary);
        System.out.println("----------------------------------");
    }
}
