package com.targetindia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee extends Person{
    private int id;
    private String department;
    private double salary;

    @Override
    public String toString() {
        return "Employee(id=%d, salary=%.2f, department=%s) %s".formatted(id, salary, department, super.toString());
    }

    @Override
    public void print() {
        System.out.printf("ID       = %d%n", this.id);
        super.print();
        System.out.printf("Dept     = %s%n", this.department);
        System.out.printf("Salary   = %.2f%n", this.salary);
    }

}
