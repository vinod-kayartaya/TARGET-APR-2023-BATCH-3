package com.targetindia.programs;


import com.targetindia.model.Person;

public class PersonObjectsDemo {
    public static void main(String[] args) {

        // a reference variable in the stack frame for "main"
        Person p1; // occupies 8 bytes and holds reference of an object

        // create an object of Person class and assign the reference to "p1"
        p1 = new Person();

        p1.name = "Vinod";
        p1.age = 49;
        p1.height = 5.8;
        p1.city = "Bangalore";


        System.out.printf("p1 is %s%n", p1);
    }
}
