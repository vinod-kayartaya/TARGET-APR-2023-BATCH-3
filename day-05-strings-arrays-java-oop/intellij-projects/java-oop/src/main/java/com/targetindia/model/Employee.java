package com.targetindia.model;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private double salary;
    private String department;

    public void setSalary(double salary) {
        if (salary < 15000) {
            throw new RuntimeException("Salary must be >= ₹15000");
        }
        this.salary = salary;
    }
}
