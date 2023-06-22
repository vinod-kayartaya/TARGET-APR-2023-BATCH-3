package com.targetindia.programs;

import com.targetindia.entity.Category;
import com.targetindia.entity.Product;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class GetOneCategory {
    public static void main(String[] args) {
        try (EntityManager em = JpaUtil.entityManager()) {
            int id = KeyboardUtil.getInt("Enter category id to search: ");
            Category c1 = em.find(Category.class, id);
            System.out.printf("Category name   : %s%n", c1.getCategoryName());
            System.out.printf("Description     : %s%n", c1.getDescription());
            System.out.printf("Picture exists? : %s%n", c1.getPicture() == null ? "No" : "Yes");

            System.out.println("Products in this category are:");
            c1.getProductList()
                    .stream()
                    .map(p -> "%2d %s".formatted(p.getProductId(), p.getProductName()))
                    .forEach(System.out::println);
        } // em is closed; no db connection
    }
}
