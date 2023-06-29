package com.targetindia.programs;

import com.targetindia.config.AppConfig;
import com.targetindia.dao.ProductDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GetAllProducts {
    public static void main(String[] args) {
        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)
        ) {
            ProductDao dao = ctx.getBean(ProductDao.class);
            System.out.printf("dao is an instanceof %s class%n", dao.getClass().getName());

            dao.findAll().forEach(System.out::println);
        }
    }
}
