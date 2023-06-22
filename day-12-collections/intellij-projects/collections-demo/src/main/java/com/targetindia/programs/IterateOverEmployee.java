package com.targetindia.programs;

import com.targetindia.entity.Employee;

public class IterateOverEmployee {

    public static void main(String[] args) {
        Employee e1 = new Employee(1112, "John Scott", "Administration", 35000.0);

        for(Object o: e1){
            System.out.println(o);
        }
    }
}
