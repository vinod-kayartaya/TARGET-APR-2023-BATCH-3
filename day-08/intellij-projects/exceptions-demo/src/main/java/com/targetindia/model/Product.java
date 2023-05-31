package com.targetindia.model;

import com.targetindia.exceptions.BlankNameException;
import com.targetindia.exceptions.IdException;
import com.targetindia.exceptions.NullNameException;
import com.targetindia.exceptions.UnitPriceException;

public class Product {
    private int id;
    private String name;
    private double unitPrice;

    public Product() {
    }

    public Product(int id, String name, double unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws IdException {
        if (id <= 0) {
            throw new IdException("ID must be > 0");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws BlankNameException, NullNameException {
        if (name == null) {
            throw new NullNameException();
        }
        if (name.isBlank()) {
            throw new BlankNameException();
        }
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) throws UnitPriceException{
        if (unitPrice < 0) {
            throw new UnitPriceException();
        }
        this.unitPrice = unitPrice;
    }

    public void print() {
        System.out.printf("ID         : %d%n", id);
        System.out.printf("Name       : %s%n", name);
        System.out.printf("Unit price : ₹%.2f%n", unitPrice);
        System.out.println();
    }
}
