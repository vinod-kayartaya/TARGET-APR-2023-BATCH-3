package com.targetindia.programs;

import com.targetindia.model.Employee;
import com.targetindia.model.Person;
import com.targetindia.model.Student;

public class PolymorphismDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setName("Ramesh");
        e1.setEmail("ramesh@xmpl.com");
        e1.setCity("Chennai");
        e1.setId(11223);
        e1.setSalary(35500);
        e1.setDepartment("Sales");

        Student s1 = new Student();
        s1.setRollno(17821);
        s1.setMajor("Physics");
        s1.setGpa(4.8);
        s1.setName("Sandeep");
        s1.setEmail("sandeep@xmpl.com");
        s1.setCity("Bangalore");

        Person p1;

        p1 = e1; // no error; since Person IS-A Employee
        // RHS is an employee who is also a person
        // LHS is a reference of a Person and hence, it is referring to an object of a Person
        // Here a sub-type is cast to a super type; which is called UP-CASTING; which is done implicitly
        p1.print();
        System.out.println();

        p1 = s1; // no problem too!

        p1.print();

        // for the compiler, lines 31 and 35 are identical.
        // compiler checks if "print()" is a valid method in the data type of "p1", which is Person.
        // Since such a function exists in Person, compiler compiles successfully.

        // However, during the runtime, the "print()" method is taken from the object's data type
        // For line 31, p1 is a reference to a Employee object, and hence the print() is taken from
        // the Employee class. Whereas, for line 35, p1 refers to an object of a Student, and the
        // method "print()" is taken from Student class.
    }
}
