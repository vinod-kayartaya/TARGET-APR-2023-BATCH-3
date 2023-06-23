package com.targetindia.programs;

import com.targetindia.config.AppConfig3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class AnotherBeanScopeDemo {
    public static void main(String[] args) {
        log.trace("creating a new spring container using AppConfig3....");
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig3.class)) {
            log.trace("Spring container is ready!");

            for(int i=0; i<5; i++){
                System.out.printf("---------- calling ctx.getBean(\"jdbcShipperDao\"); for %d times%n", i+1);
                ctx.getBean("jdbcShipperDao");
                System.out.printf("---------- called ctx.getBean(\"jdbcShipperDao\"); for %d times%n", i+1);
            }

            for(int i=0; i<5; i++){
                System.out.printf("---------- calling ctx.getBean(\"shipperDao\"); for %d times%n", i+1);
                ctx.getBean("shipperDao");
                System.out.printf("---------- called ctx.getBean(\"shipperDao\"); for %d times%n", i+1);
            }
        }
    }
}
