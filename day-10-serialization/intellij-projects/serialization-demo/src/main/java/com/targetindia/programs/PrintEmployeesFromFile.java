package com.targetindia.programs;

import com.targetindia.model.Employee;
import lombok.SneakyThrows;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class PrintEmployeesFromFile {
    @SneakyThrows
    public static void main(String[] args) {
        try (
                FileInputStream file = new FileInputStream("employees.dat");
                ObjectInputStream in = new ObjectInputStream(file);
        ) {
            while(true){
                try {
                    Object obj = in.readObject();
                    if(obj instanceof Employee){
                        Employee emp = (Employee) obj;
                        emp.print();
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        }
    }
}
