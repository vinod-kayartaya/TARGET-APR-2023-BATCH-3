package com.targetindia.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Employee implements Serializable {

    static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private double salary;
    private String department;
    private transient Address address; // not serializable

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    public void print(){
        System.out.println();
        System.out.printf("Id        : %d%n", id);
        System.out.printf("Name      : %s%n", name);
        System.out.printf("Salary    : %.2f%n", salary);
        System.out.printf("Department: %s%n", department);
        System.out.printf("Address   : %s%n", address);
    }

}
