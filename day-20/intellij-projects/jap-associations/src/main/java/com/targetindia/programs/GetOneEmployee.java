package com.targetindia.programs;

import com.targetindia.entity.Employee;
import com.targetindia.entity.Supplier;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GetOneEmployee {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter employee id to search: ");
        try (EntityManager em = JpaUtil.entityManager()) {
            Employee e1 = em.find(Employee.class, id);
            System.out.printf("Name              : %s %s %s%n", e1.getTitleOfCourtesy(), e1.getLastname(), e1.getFirstname());
            System.out.printf("Job title         : %s%n", e1.getTitle());
            System.out.printf("Address           : %s%n", e1.getAddress().getStreetAddress());
            System.out.printf("City              : %s%n", e1.getAddress().getCity());
            System.out.printf("Region            : %s%n", e1.getAddress().getRegion());
            System.out.printf("Country           : %s%n", e1.getAddress().getCountry());

            if (e1.getManager() != null) {
                Employee e2 = e1.getManager();
                System.out.printf("Manager name      : %s %s %s%n", e2.getTitleOfCourtesy(), e2.getLastname(), e2.getFirstname());
            }

            List<Employee> subordinates = e1.getSubordinates();
            if (subordinates != null && !subordinates.isEmpty()) {
                System.out.println("Following employees work under this employee:");
                subordinates.stream()
                        .map(e -> "\t%s %s %s".formatted(e.getTitleOfCourtesy(), e.getLastname(), e.getFirstname()))
                        .forEach(System.out::println);
            }

        }
    }
}
