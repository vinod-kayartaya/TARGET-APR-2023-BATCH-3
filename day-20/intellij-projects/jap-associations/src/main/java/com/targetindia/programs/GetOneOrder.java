package com.targetindia.programs;

import com.targetindia.entity.Order;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class GetOneOrder {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter order id to search: ");
        try (EntityManager em = JpaUtil.entityManager()) {
            Order order1 = em.find(Order.class, id);

            System.out.println(order1.getCustomer().getCompanyName());
            System.out.println(order1.getEmployee().getFirstname());
            System.out.println(order1.getShipper().getCompanyName());

        }
    }
}
