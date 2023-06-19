package com.targetindia.programs;

import com.targetindia.entity.Category;
import com.targetindia.entity.Product;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class GetOneProduct {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter product id to search: ");
        Product p1;

        try (EntityManager em = JpaUtil.entityManager()) {
            p1 = em.find(Product.class, id);
            // now inside the em cache, there are two entity objects
            // 1. a product entity
            // 2. corresponding category entity
        } // entity manager is closed and p1 becomes a detached entity

        if (p1 == null) {
            System.out.printf("No product found for id %d%n", id);
            return;
        }

        System.out.printf("Product name  : %s%n", p1.getProductName());
        System.out.printf("Unit price    : $ %.2f%n", p1.getUnitPrice());
        System.out.printf("Discontinued? : %s%n", p1.getDiscontinued() == 1 ? "Yes" : "No");
        System.out.printf("Category      : %s (%s)%n",
                p1.getCategory().getCategoryName(),
                p1.getCategory().getDescription());
        System.out.printf("Supplied by   : %s, %s %s%n",
                p1.getSupplier().getCompanyName(),
                p1.getSupplier().getAddress().getCity(),
                p1.getSupplier().getAddress().getCountry());
    }
}
