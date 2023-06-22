package com.targetindia.programs;

import com.targetindia.entity.Customer;
import com.targetindia.entity.Supplier;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class GetOneCustomer {
    public static void main(String[] args) {

        String id = KeyboardUtil.getString("Enter customer id to search: ");
        try (EntityManager em = JpaUtil.entityManager()) {
            Customer c1 = em.find(Customer.class, id);
            if (c1 == null) {
                System.out.printf("No customer found for id '%s'%n", id);
                return;
            }

            System.out.printf("Company name      : %s%n", c1.getCompanyName());
            System.out.printf("Contact person    : %s (%s)%n", c1.getContactName(), c1.getContactTitle());
            System.out.printf("Address           : %s%n", c1.getAddress().getStreetAddress());
            System.out.printf("City              : %s%n", c1.getAddress().getCity());
            System.out.printf("Region            : %s%n", c1.getAddress().getRegion());
            System.out.printf("Country           : %s%n", c1.getAddress().getCountry());

            c1.getOrders().forEach(GetOneOrder::printOrder);
        }
    }
}
