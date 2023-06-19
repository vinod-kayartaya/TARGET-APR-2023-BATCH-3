package com.targetindia.programs;

import com.targetindia.entity.Product;
import com.targetindia.entity.Shipper;
import com.targetindia.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Arrays;

public class JpqlDemos {
    private static EntityManager em;

    public static void main(String[] args) {
        em = JpaUtil.entityManager();

        demo10();

        em.close();
    }

    private static void demo10() {
        // display the order id along with order total amount for all the orders by a customer
        String ql = "select ord1.orderId, sum(li.unitPrice*li.quantity*(1-li.discount)) from Order ord1 " +
                "join ord1.lineItems li " +
                "where lower(ord1.customer.customerId) = lower(?1) " +
                "group by ord1.orderId";
        TypedQuery<Object[]> qry = em.createQuery(ql, Object[].class);
        qry.setParameter(1, "vinet");
        qry.getResultStream()
                .map(Arrays::toString)
                .forEach(System.out::println);
    }

    private static void demo9() {
        // display products by page number
        int pageSize = 10, pageNum = 4;
        int offset = (pageNum - 1) * pageSize;
        TypedQuery<Product> qry = em.createQuery("from Product", Product.class);
        qry.setFirstResult(offset);
        qry.setMaxResults(pageSize);
        qry.getResultList().forEach(JpqlDemos::printProduct);
    }

    private static void demo8() {
        // display the category name along with the number of products in the respective category
        String ql = "select p.category.categoryName, count(p) from Product p group by p.category.categoryName order by p.category.categoryName";
        TypedQuery<Object[]> qry = em.createQuery(ql, Object[].class);
        qry.getResultStream()
                .map(ar -> "%s --> %d products".formatted(ar[0], ar[1]))
                .forEach(System.out::println);
    }

    private static void demo7() {
        // display name and price of all products supplied by the supplier company 'exotic liquids'
        String ql = "select productName, unitPrice from Product where lower(supplier.companyName) = lower(?1)";
        TypedQuery<Object[]> qry = em.createQuery(ql, Object[].class);
        qry.setParameter(1, "exotic liquids");
        qry.getResultStream()
                .map(ar -> "%s --> $%.2f".formatted(ar[0], ar[1]))
                .forEach(System.out::println);
    }

    private static void demo6() {
        // display only the names of discontinued products
        // String ql = "select p1.productName from Product p1 where p1.discontinued=1";
        String ql = "select productName from Product where discontinued=1";
        TypedQuery<String> qry = em.createQuery(ql, String.class);
        qry.getResultList().forEach(System.out::println);
    }

    private static void demo5() {
        // get the list of products based on category name
        String ql = "select p1 from Product p1 where lower(p1.category.categoryName) = lower(?1)";
        TypedQuery<Product> qry = em.createQuery(ql, Product.class);
        qry.setParameter(1, "beverages");
        qry.getResultList().forEach(JpqlDemos::printProduct);
    }

    static void demo4() {
        String ql = "from Product where unitPrice between :MIN and :MAX order by unitPrice";
        TypedQuery<Product> qry = em.createQuery(ql, Product.class);
        qry.setParameter("MIN", 50);
        qry.setParameter("MAX", 500);
        qry.getResultList().forEach(JpqlDemos::printProduct);
    }


    static void demo3() {
        String ql = "from Product where unitPrice between ?1 and ?2 order by unitPrice";
        TypedQuery<Product> qry = em.createQuery(ql, Product.class);
        qry.setParameter(1, 50);
        qry.setParameter(2, 500);
        qry.getResultList().forEach(JpqlDemos::printProduct);
    }

    static void demo2() {
        // get the out-of-stock products
        String ql = "from Product where unitsInStock=0"; // unitsInStock is not the column
        TypedQuery<Product> qry = em.createQuery(ql, Product.class);
        qry.getResultStream()
                .map(Product::getProductName)
                .forEach(System.out::println);
    }

    static void demo1() {
        // get all shippers
        // sql --> SELECT * FROM SHIPPERS
        // jpql --> select s1 from Shipper s1
        //      --> from Shipper
        String ql = "FROM Shipper";
        TypedQuery<Shipper> qry = em.createQuery(ql, Shipper.class);
        qry.getResultStream()
                .forEach(System.out::println);
    }

    static void printProduct(Product p) {
        System.out.printf("%d - %s (%s) --> $%.2f%n",
                p.getProductId(),
                p.getProductName(),
                p.getCategory().getCategoryName(),
                p.getUnitPrice());
    }

}
