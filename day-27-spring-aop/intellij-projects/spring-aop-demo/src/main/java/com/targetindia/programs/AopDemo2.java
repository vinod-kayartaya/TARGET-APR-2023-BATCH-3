package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import com.targetindia.dao.DaoException;
import com.targetindia.dao.ProductDao;
import com.targetindia.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Slf4j
public class AopDemo2 {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class)) {
            ProductDao dao = ctx.getBean(ProductDao.class);
            log.trace("dao is an instanceof '{}' class", dao.getClass().getName());

            try{
                List<Product> list = dao.findAllOutOfStockProducts();
                log.trace("{} products are not in stock", list.size());
            }
            catch(DaoException e){
                log.warn("There was an error: {}", e.getMessage());
            }
        }
    }
}
