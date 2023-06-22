package com.targetindia.programs;

import com.targetindia.dao.ProductDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class GetProductCount {
    public static void main(String[] args) {

        try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config1.xml")){
            // the spring container now has 2 beans: dataSource, dao

            ProductDao dao = ctx.getBean(ProductDao.class);
            log.trace("dao is an instanceof {} class", dao.getClass().getName());
            long pc = dao.count();
            log.trace("There are {} products", pc);
        }

    }
}
