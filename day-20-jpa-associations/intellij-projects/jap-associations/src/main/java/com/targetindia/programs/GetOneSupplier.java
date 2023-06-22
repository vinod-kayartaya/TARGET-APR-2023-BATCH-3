package com.targetindia.programs;

import com.targetindia.entity.Product;
import com.targetindia.entity.Supplier;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class GetOneSupplier {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter supplier id to search: ");
        try (EntityManager em = JpaUtil.entityManager()) {
            Supplier s1 = em.find(Supplier.class, id);
            System.out.printf("Company name      : %s%n", s1.getCompanyName());
            System.out.printf("Contact perso     : %s (%s)%n", s1.getContactName(), s1.getContactTitle());
            System.out.printf("Address           : %s%n", s1.getAddress().getStreetAddress());
            System.out.printf("City              : %s%n", s1.getAddress().getCity());
            System.out.printf("Region            : %s%n", s1.getAddress().getRegion());
            System.out.printf("Country           : %s%n", s1.getAddress().getCountry());

            System.out.println("Products supplied by this supplier are: ");
            System.out.println("---------------------------------------");
            s1.getProductList()
                    .stream()
                    .map(GetOneSupplier::prouductToString)
                    .forEach(System.out::println);
        }
    }

    static String prouductToString(Product p) {
        return "(%d) %s (%s) --> $%.2f".formatted(
                p.getProductId(),
                p.getProductName(),
                p.getCategory().getCategoryName(),
                p.getUnitPrice());
    }
}
