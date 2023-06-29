package com.kvinod.programs;

import com.kvinod.config.AppConfig;
import com.kvinod.entity.Shipper;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class)){
            EntityManager em = ctx.getBean(EntityManager.class);
            Shipper s1 = em.find(Shipper.class, 2);
            log.trace("s1 = {}", s1);
        }
    }
}
