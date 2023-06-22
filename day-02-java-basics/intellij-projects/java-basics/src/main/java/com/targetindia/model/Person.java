package com.targetindia.model;

public class Person {
    public String name; // 8 bytes; reference
    public int age; // 4 bytes; primitive
    public double height; // 8 bytes; primitive
    public String city; // 8 bytes; reference


    // similar to the __str__() magic method in Python
    // this method is used whenever an object is being converted into a string
    // for example, System.out.println("p1 = " + p1);
    // for example, System.out.printf("p1 = %s%n", p1);
    public String toString() {
        return "An object of com.targetindia.model.Person class (Name='%s', Age=%d, Height=%f, City='%s')".formatted(
                name, age, height, city);
    }
}

// "vinod", 49, 5.7, "bangalore"
