package com.targetindia.programs;

import com.targetindia.config.AppConfig3;
import com.targetindia.dao.ShipperDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class BeanScopeDemo {
    public static void main(String[] args) {
        log.trace("creating a new spring container using AppConfig3....");
        try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig3.class)){
            log.trace("Spring container is ready!");

            System.out.println("-------------");
            ShipperDao dao1 = ctx.getBean("jdbcShipperDao", ShipperDao.class); // singleton bean
            System.out.println("-------------");
            ShipperDao dao2 = ctx.getBean("jdbcShipperDao", ShipperDao.class); // singleton bean
            System.out.println("-------------");
            // both dao1 and dao2 will get the reference of the same object, because the object was
            // created in advance during the construction of spring container.
            log.trace("dao1==dao2 is {}", dao1==dao2);
            log.trace("dao1.hashCode is {}, dao2.hashCode is {}", dao1.hashCode(), dao2.hashCode());

            System.out.println("-------------");
            ShipperDao dao3 = ctx.getBean("shipperDao", ShipperDao.class); // prototype bean
            System.out.println("-------------");
            ShipperDao dao4 = ctx.getBean("shipperDao", ShipperDao.class); // prototype bean
            System.out.println("-------------");
            // dao1 and dao2 refer to two different beans.
            // the "prototype" beans are created only when it is needed, for example, when ctx.getBean(..)
            // is called.
            log.trace("dao3==dao4 is {}", dao3==dao4);
            log.trace("dao3.hashCode is {}, dao4.hashCode is {}", dao3.hashCode(), dao4.hashCode());


        }
    }
}
