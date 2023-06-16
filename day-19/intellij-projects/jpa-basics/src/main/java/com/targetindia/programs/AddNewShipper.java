package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.security.Key;

public class AddNewShipper {
    public static void main(String[] args) {
        try (
                EntityManager em = JpaUtil.entityManager()
        ) {
            System.out.println("Enter new shipper data: ");
            int id = KeyboardUtil.getInt("ID          : ");
            String name = KeyboardUtil.getString("Company name: ");
            String phone = KeyboardUtil.getString("Phone number: ");

            // from JPA's perspective, this object is called "new/unmanaged" object
            Shipper s1 = new Shipper(id, name, phone);
            em.persist(s1); // now, EntityManager manages the lifecycle object, and is called as "managed" object
            // Yoy may think of em as a cache of entity objects, and in that cache, now we added "s1"
            // s1 is given a status of "new" (other than this, there may be "dirty" and "removed" objects in the cache)

            // during the commit, SQL DML commands are generated based on the status of persistent objects
            // "new"  --> insert
            // "dirty" --> update
            // "removed" --> delete

            EntityTransaction tx = em.getTransaction();
            tx.begin();
            try {
                // at this time, "em" has one persistent object with status = "new"
                tx.commit(); // this will generate 1 sql insert command and sends to the DB
                System.out.println("new shipper data added!");
            } catch (Exception e) {
                tx.rollback();
                System.out.println("couldn't add new shipepr data");
                throw new RuntimeException(e);
            }
        } // em.close() called here automatically
    }
}
