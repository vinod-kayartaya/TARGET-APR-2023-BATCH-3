package com.targetindia.programs;

import com.targetindia.model.Employee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeDemo {
    public static void main(String[] args) {

        Employee e1;
        e1 =new Employee();

        e1.setName("Ramesh");
        e1.setEmail("ramesh@xmpl.com");
        e1.setCity("Chennai");
        e1.setId(11223);
        e1.setSalary(35500);
        e1.setDepartment("Sales");

        System.out.println(e1);
        log.trace("e1 = {}", e1);
        log.trace("e1.name = {}", e1.getName());

        e1.print();
    }
}
