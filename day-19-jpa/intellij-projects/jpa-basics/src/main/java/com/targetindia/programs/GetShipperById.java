package com.targetindia.programs;

import com.targetindia.entity.Shipper;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetShipperById {
    public static void main(String[] args) {
        try(EntityManager em = JpaUtil.entityManager()){
            log.trace("em is an instanceof {} class", em.getClass().getName());
            int id = KeyboardUtil.getInt("Enter shipper id to search: ");
            log.trace("------------------------------------");
            Shipper s1 = em.find(Shipper.class, id); // actual SQL SELECT command is executed here
            log.trace("------------------------------------");
            log.trace("s1 = {}", s1);
        } // em.close() called here automatically
    }
}
