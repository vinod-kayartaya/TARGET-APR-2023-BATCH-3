package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import com.targetindia.dao.ProductDao;
import com.targetindia.model.Product;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


@Slf4j
public class TestProductDaoMethods {
    static ProductDao dao;

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class)) {
            dao = ctx.getBean(ProductDao.class);
            log.trace("dao is an instanceof {} class", dao.getClass().getName());

            // demo1();
            // demo2();
            // demo3();
            // demo4();
            // demo5();
            // demo6();
            // demo7();
            // demo8();
            demo9();
        }
    }
    static void demo9(){
        int productId = KeyboardUtil.getInt("Enter product id to search: ");
        Product p1 = dao.findById(productId);
        double newPrice = KeyboardUtil.getDouble("Enter new unit price: (" + p1.getUnitPrice() + ") ");
        p1.setUnitPrice(newPrice);
        dao.update(p1);
    }

    static void demo8(){
        double min = KeyboardUtil.getDouble("Enter minimum price: ");
        double max = KeyboardUtil.getDouble("Enter maximum price: ");
        List<Product> list = dao.findAllByPriceRange(min, max);
        list.forEach(p -> System.out.printf("%2d %s --> $%.2f%n",
                p.getProductId(),
                p.getProductName(),
                p.getUnitPrice()));
    }

    static void demo7() {
        List<Product> list = dao.findAllOutOfStockProducts();
        list.forEach(p -> System.out.printf("%2d %s --> $%.2f%n",
                p.getProductId(),
                p.getProductName(),
                p.getUnitPrice()));
    }

    static void demo6() {
        List<Product> list = dao.findAllDiscontinuedProducts();
        list.forEach(p -> System.out.printf("%2d %s --> $%.2f%n",
                p.getProductId(),
                p.getProductName(),
                p.getUnitPrice()));
    }


    static void demo5() {
        int supplierId = KeyboardUtil.getInt("Enter supplier id to search products: ");
        List<Product> list = dao.findAllBySupplierId(supplierId);
        list.forEach(p -> System.out.printf("%2d %s --> $%.2f%n",
                p.getProductId(),
                p.getProductName(),
                p.getUnitPrice()));
    }

    static void demo4() {
        int categoryId = KeyboardUtil.getInt("Enter category id to search products: ");
        List<Product> list = dao.findAllByCategoryId(categoryId);
        list.forEach(p -> System.out.printf("%2d %s --> $%.2f%n",
                p.getProductId(),
                p.getProductName(),
                p.getUnitPrice()));
    }

    static void demo3() {
        List<Product> list = dao.findAll();
        list.forEach(p -> System.out.printf("%2d %s --> $%.2f%n",
                p.getProductId(),
                p.getProductName(),
                p.getUnitPrice()));
    }

    static void demo2() {
        int productId = KeyboardUtil.getInt("Enter product id to search: ");
        Product p1 = dao.findById(productId);
        if (p1 == null) {
            log.trace("No product found for id {}", productId);
        } else {
            log.trace("product for id {} is {}", productId, p1);
        }
    }

    static void demo1() {
        long pc = dao.count();
        log.trace("product count = {}", pc);
    }
}
