package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ModifyShipperCompanyName {

    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter shipper id search: ");
        Shipper s1 = getShipperById(id);
        // at this time, the "em" created in getShipperById() is closed, and s1
        // is in the JVM, but not part of any entity manager. hence it is called "detached" object.

        String newCompanyName = KeyboardUtil.getString("Enter new company name: [" + s1.getCompanyName() + "] ");
        if(newCompanyName.isBlank()){
            System.out.println("Operation cancelled!");
            return;
        }

        s1.setCompanyName(newCompanyName);
        try(EntityManager em = JpaUtil.entityManager()){
            // the cache in em is empty
            em.merge(s1);
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            try {
                // an SQL SELECT statement is used to fetch the details for s1.getShipperId(), and then
                // this data is compared with that of s1. If they both are same, then s1 is not a dirty object,
                // otherwise s1 is a dirty object, and an SQL UPDATE command is executed
                tx.commit();
                System.out.println("Phone number updated!");
            } catch (Exception e) {
                tx.rollback();
                System.out.println("Something went wrong");
            }
        } // em.close() called here
    }

    static Shipper getShipperById(int id) {
        try (
                EntityManager em = JpaUtil.entityManager()
        ) {
            Shipper s1 = em.find(Shipper.class, id);
            // at this time, s1 is part of the em's cache, and is called as "persistent" object
            return s1;
        } // em.close() called here
    }


}
