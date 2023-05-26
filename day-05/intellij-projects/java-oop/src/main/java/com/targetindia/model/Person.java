package com.targetindia.model;

public class Person {
    private String name;
    private int age;
    private double height;
    private String city;

    // this is the way to pass values to the private members
    // this such functions are called "setters" or "mutators"
    public void setName(String name){
        if(name.isBlank()){
            throw new RuntimeException("Name cannot be blank!");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if(age<=0){
            throw new RuntimeException("Age must be > 0");
        }
        this.age = age;
    }

    public void setHeight(double height) {
        if(height<=0){
            throw new RuntimeException("Height must be > 0");
        }
        this.height = height;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public String getCity() {
        return city;
    }

    public void print(){
        System.out.printf("Name     = %s%n", name);
        System.out.printf("Age      = %d years%n", age);
        System.out.printf("Height   = %.1f%n", height);
        System.out.printf("City     = %s%n", city);
        System.out.println();
    }
}
