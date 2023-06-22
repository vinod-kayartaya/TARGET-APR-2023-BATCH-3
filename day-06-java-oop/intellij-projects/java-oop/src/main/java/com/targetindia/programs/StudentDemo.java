package com.targetindia.programs;

import com.targetindia.model.Student;

public class StudentDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setRollno(17821);
        s1.setMajor("Physics");
        s1.setGpa(4.8);
        s1.setName("Sandeep");
        s1.setEmail("sandeep.xmpl.com");
        s1.setCity("Bangalore");

        s1.print();
    }
}
