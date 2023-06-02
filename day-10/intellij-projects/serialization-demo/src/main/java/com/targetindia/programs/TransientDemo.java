package com.targetindia.programs;

import com.targetindia.model.Address;
import com.targetindia.model.Employee;
import lombok.SneakyThrows;

import java.io.*;

public class TransientDemo {
    @SneakyThrows
    public static void demo1() {
        Employee e1 = new Employee(1212, "Harshit", 23000, "ADMIN");
        Address adr = new Address("Bangalore", "Karnataka", 560012);
        e1.setAddress(adr);

        System.out.println("Saving this data to a file called harshit.out....");
        e1.print();

        try (
                FileOutputStream file = new FileOutputStream("harshit.out");
                ObjectOutputStream out = new ObjectOutputStream(file);
        ) {
            out.writeObject(e1);
            System.out.println("Done!");
        }
    }

    @SneakyThrows
    public static void demo2() {
        try (
                FileInputStream file = new FileInputStream("harshit.out");
                ObjectInputStream in = new ObjectInputStream(file);
        ) {
            Employee emp = (Employee) in.readObject();
            emp.print();
        }
    }

    public static void main(String[] args) {
        demo2();
    }
}
