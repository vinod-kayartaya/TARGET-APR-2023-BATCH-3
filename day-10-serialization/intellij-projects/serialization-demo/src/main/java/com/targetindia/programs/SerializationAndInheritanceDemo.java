package com.targetindia.programs;

import com.targetindia.model.Employee;
import com.targetindia.model.Salesman;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationAndInheritanceDemo {
    @SneakyThrows
    public static void demo1() {
        Salesman s1 = new Salesman();
        s1.setId(1112);
        s1.setName("Shyam");
        s1.setSalary(45600);
        s1.setCommissionPercent(5.5);
        s1.setDepartment("SALES");

        try (
                FileOutputStream file = new FileOutputStream("shyam.out");
                ObjectOutputStream out = new ObjectOutputStream(file);
        ) {
            out.writeObject(s1);
            System.out.println("Done!");
        }
    }

    @SneakyThrows
    static void demo2(){
        try (
                FileInputStream file = new FileInputStream("shyam.out");
                ObjectInputStream in = new ObjectInputStream(file);
        ) {
            // LHS is a reference of Employee
            // RHS is an object of Salesman
            Employee emp = (Employee) in.readObject();
            emp.print(); // print() called from Salesman
        }
    }


    public static void main(String[] args) {
        demo2();
    }
}
