package com.targetindia.model;

import lombok.Data;

@Data
public class Salesman extends Employee { // because of inheritance, this class is automatically serializable
    private double commissionPercent;

    public void print() {
        super.print();
        System.out.printf("Comm %%    : %.2f %n", commissionPercent);
    }
}
