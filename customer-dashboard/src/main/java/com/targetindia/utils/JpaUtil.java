package com.targetindia.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class JpaUtil {
    private JpaUtil() {
    }

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("h2_targetdb_b3");
    }
    public static EntityManager entityManager(){
        return emf.createEntityManager();
    }
}
