package com.targetindia.programs;

import com.targetindia.model.Employee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InheritanceAndConstructorDemo {
    public static void main(String[] args) {

        Employee e1, e2;

        e1 = new Employee();
        e2 = new Employee(1122, "Kishore", "Kumar", 45000);

//        log.trace("e1 = {}", e1);
//        log.trace("e2 = {}", e2);
    }
}
