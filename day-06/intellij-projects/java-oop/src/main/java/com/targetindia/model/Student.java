package com.targetindia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends Person{
    private int rollno;
    private double gpa;
    private String major;

    @Override
    public void print() {
        System.out.printf("Rollno   = %s%n", this.rollno);
        super.print();
        System.out.printf("GPA      = %.2f%n", this.gpa);
        System.out.printf("Major    = %s%n", this.major);
    }
}
