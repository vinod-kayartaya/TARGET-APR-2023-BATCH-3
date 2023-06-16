package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ModifyShipperPhone {
    public static void main(String[] args) {
        try (
                EntityManager em = JpaUtil.entityManager()
        ) {
            int id = KeyboardUtil.getInt("Enter shipper id to search: ");
            Shipper s1 = em.find(Shipper.class, id); // here the data from the table is retrieved as an entity and
            // kept in the em's cache. Since the data was retrieved by JPA, it is already a "managed" object.
            // any changes to a managed object will automatically mark it as a "dirty" object

            String newPhone = KeyboardUtil.getString("Enter phone number: [" + s1.getPhone() + "] ");
            if (!newPhone.isBlank()) {
                s1.setPhone(newPhone); // now s1 becomes "dirty" only if s1.getPhone() is different from "newPhone"

                EntityTransaction tx = em.getTransaction();
                tx.begin();
                try {
                    tx.commit(); // execute SQL UPDATE commands for each of the "dirty" managed objects
                    System.out.println("Phone number updated!");
                } catch (Exception e) {
                    tx.rollback();
                    System.out.println("Something went wrong");
                }
            } else {
                System.out.println("Update cancelled!");
            }
        }// em.close() called here automatically
    }
}
