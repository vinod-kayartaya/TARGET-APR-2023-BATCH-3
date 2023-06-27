package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import com.targetindia.dao.ProductDao;
import com.targetindia.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Slf4j
public class AopDemo {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class)){
            ProductDao dao = ctx.getBean(ProductDao.class);
            log.trace("dao is an instanceof '{}' class", dao.getClass().getName());

            long pc = dao.count();
            log.trace("product count = {}", pc);

            List<Product> list;
            list = dao.findAll();
            log.trace("list.size() = {}", list.size());

            list = dao.findAllOutOfStockProducts();
            log.trace("{} products are not in stock", list.size());

            list = dao.findAllDiscontinuedProducts();
            log.trace("{} products have been discontinued", list.size());

            int id = 1;
            list = dao.findAllBySupplierId(id);
            log.trace("supplier with id {} has supplied {} products", id, list.size());

            list = dao.findAllByCategoryId(id);
            log.trace("there are {} products in the category with id {}", list.size(), id);

            double min = 50;
            double max = 500;
            list = dao.findAllByPriceRange(min, max);
            log.trace("there are {} products between ${} and ${}", list.size(), min, max);

            min=500;
            max=50;
            list = dao.findAllByPriceRange(min, max);
            log.trace("there are {} products between ${} and ${}", list.size(), min, max);

            Product p = dao.findById(id);
            log.trace("product with id {} is {}", id, p);

        }
    }
}
