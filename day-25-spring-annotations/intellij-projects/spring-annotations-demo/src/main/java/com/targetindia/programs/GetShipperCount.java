package com.targetindia.programs;

import com.targetindia.config.AppConfig2;
import com.targetindia.dao.ShipperDao;
import com.targetindia.entity.Shipper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class GetShipperCount {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig2.class)){

            log.trace("spring container is ready with beans from AppConfig2.class");
            ShipperDao dao = ctx.getBean(ShipperDao.class);
            log.trace("in GetShipperCount.main(), dao is an instanceof {}", dao.getClass().getName());

            long sc = dao.count();
            log.trace("There are {} shippers", sc);

            Shipper s = dao.get(2);
            log.trace("shipper with id 2 is {}", s);

            dao.getAll().forEach(System.out::println);

        }
    }
}
