package com.targetindia.programs;

import com.targetindia.model.Employee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateEmployeeObject {
    public static void main(String[] args) {
        Employee e1 = new Employee();

        e1.setId(1122);
        e1.setDepartment("ADMIN");
        e1.setEmail("ramesh@xmpl.com");
        e1.setFirstname("Ramesh");
        e1.setLastname("Iyer");
        e1.setSalary(22000);

        log.trace("e1 = {}", e1);
    }
}
