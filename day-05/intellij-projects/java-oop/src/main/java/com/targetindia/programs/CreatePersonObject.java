package com.targetindia.programs;


import com.targetindia.model.Person;

public class CreatePersonObject {

    public static void main(String[] args) {
        Person p1; // we can create a reference variable, if the class is public (or resides in the same package as this class)

        p1 = new Person(); // we can create an object using this constructor, only if the constructor is public
        // a no-argument public constructor is given by the compiler, if and only if the class does not have any constructors


        p1.setName("Vinod"); // p1.name = "Vinod";
        p1.setAge(49);
        p1.setCity("Bangalore");
        p1.setHeight(5.8);
        p1.print();

        System.out.printf("%s, aged about %d years, lives in %s%n", p1.getName(), p1.getAge(), p1.getCity());
    }
}
