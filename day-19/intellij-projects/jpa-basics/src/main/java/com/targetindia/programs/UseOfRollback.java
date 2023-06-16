package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UseOfRollback {
    public static void main(String[] args) {
        Shipper[] shippers = {
                new Shipper(4, "XYZ Transports", "(234) 948-4422"),
                new Shipper(5, "ASDF Transports", "(234) 948-7865"),
                new Shipper(6, "QWERT Transports", "(234) 948-7890"),
        };
        try(EntityManager em = JpaUtil.entityManager()){
            for(Shipper shipper: shippers){
                em.persist(shipper);
            }

            EntityTransaction tx = em.getTransaction();
            tx.begin();
            try{
                System.out.println("--------------------------------------------------");
                tx.commit(); // 3 insert commands
                System.out.println("--------------------------------------------------");
            }
            catch (Exception e){
                tx.rollback();
                System.out.printf("Error: %s%n", e.getMessage());
            }
        }
    }
}
