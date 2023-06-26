package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import com.targetindia.model.Shipper;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
public class JdbcTemplateDemos {

    static JdbcTemplate template;

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class)) {
            template = ctx.getBean(JdbcTemplate.class);

            // demo1();
            // demo2();
            // demo3();
            // demo4();
            // demo5();
            // demo6();
            // demo7();
            // demo8();
            // demo9();
            demo10();


        }
    }

    static void demo10() {
        int shipperId = KeyboardUtil.getInt("Enter shipper id to search: ");
        String sql = "select * from shippers where shipper_id=?";
        Shipper s1 = null;
        try {
            s1 = template.queryForObject(sql, srm, shipperId);
            System.out.printf("Company name: %s%nPhone number: %s%n",
                    s1.getCompanyName(),
                    s1.getPhone());
        } catch (DataAccessException e) {
            System.out.printf("No data found for shipper id %d%n", shipperId);
        }
    }

    static RowMapper<Shipper> srm = (rs, rowNum) -> {
        Shipper s = new Shipper();
        s.setShipperId(rs.getInt("shipper_id"));
        s.setCompanyName(rs.getString("company_name"));
        s.setPhone(rs.getString("phone"));
        return s;
    };

    static void demo9() {
        String sql = "select * from shippers";
        // we need a list of Shipper objects for the above query.
        // Best is to use the RowMapper instead of ResultSetExtractor
        List<Shipper> list = template.query(sql, srm);
        list.forEach(System.out::println);
    }

    static void demo8() {
        double min = KeyboardUtil.getDouble("Enter minimum price: ");
        double max = KeyboardUtil.getDouble("Enter maximum price: ");

        String sql = "select product_name, category_name, unit_price " +
                "from products natural join categories where unit_price between ? and ?";

        RowMapper<Object[]> rowMapper = (rs, rowNum) -> {
            log.trace("mapRow() called");
            Object[] data = new Object[3];
            for (int i = 0; i < data.length; i++) {
                data[i] = rs.getObject(i + 1);
            }
            return data;
        };

        log.trace("calling the template.query() method...");
        List<Object[]> rows = template.query(sql, rowMapper, min, max);
        log.trace("template.query() execution completed");

        rows.forEach(row -> System.out.println(Arrays.toString(row)));
    }

    static void demo7() {
        String sql = "select * from shippers";
        ResultSetExtractor<List<Shipper>> rse = (rs) -> {
            List<Shipper> list = new ArrayList<>();
            while (rs.next()) {
                Shipper s = new Shipper();
                s.setShipperId(rs.getInt("shipper_id"));
                s.setCompanyName(rs.getString("company_name"));
                s.setPhone(rs.getString("phone"));
                list.add(s);
            }
            return list;
        };

        List<Shipper> shippers = template.query(sql, rse);

        shippers.forEach(System.out::println);
    }

    static void demo6() {
        int shipperId = KeyboardUtil.getInt("Enter shipper id to search: ");
        String sql = "select * from shippers where shipper_id=?";
        // the query results in one row multiple columns

        ResultSetExtractor<Shipper> rse = (rs) -> {
            if (rs.next()) {
                Shipper s = new Shipper();
                s.setShipperId(rs.getInt("shipper_id"));
                s.setCompanyName(rs.getString("company_name"));
                s.setPhone(rs.getString("phone"));
                return s;
            } else {
                return null;
            }
        };

        Shipper s1 = template.query(sql, rse, shipperId);
        System.out.println(s1 == null ? "No data found" : s1);
    }

    static void demo5() {
        // print the product name along with category name and unit price supplied by a supplier
        int supplierId = KeyboardUtil.getInt("Enter supplier id: ");
        String sql = "select product_name, category_name, unit_price " +
                "from products natural join categories where supplier_id=?";

        // the query results in multiple rows and multiple columns
        // use the query(sql, RowCallbackHandler, Object...)

        RowCallbackHandler rch = (rs) -> {
            int rc = 0;
            while (rs.next()) {
                rc++;
                System.out.printf("%s (%s) --> $%.2f%n",
                        rs.getString("product_name"),
                        rs.getString("category_name"),
                        rs.getDouble("unit_price"));
            }
            System.out.printf("Processed %d rows%n", rc);
        };

        template.query(sql, rch, supplierId);

        // spring: opens a connection
        // me: pass the sql to be executed
        // me: pass the parameters for the sql command
        // spring: creates s prepared statement for the sql command
        // spring: sets the parameter for the query
        // spring: executes the sql
        // spring: collects the result set
        // me: process the result set
        // spring: close result set
        // spring: close statement
        // spring: close connection
        // spring: handle exception

        // this is good only when there is some logic to executed for each row.
    }

    static void demo4() {
        String city = KeyboardUtil.getString("Enter city to search for customers: ");
        String sql = "select company_name, contact_name, contact_title from customers where lower(city)=lower(?)";
        // the query results in multiple rows and multiple columns
        // Can we use the queryForList returning List<Map<String, Object>>?
        List<Map<String, Object>> customers = template.queryForList(sql, city);
        for (Map<String, Object> c : customers) {
            System.out.printf("%s (%s is a %s)%n",
                    c.get("company_name"),
                    c.get("contact_name"),
                    c.get("contact_title"));
        }
    }

    static void demo3() {
        String city = KeyboardUtil.getString("Enter city to search for customers: ");
        String sql = "select company_name from customers where lower(city)=lower(?)";
        // the query may result in 0 or more rows, with 1 column only
        // use the queryForList for such cases
        List<String> customers = template.queryForList(sql, String.class, city);

        if (customers.size() == 0) {
            System.out.println("No customers from " + city);
            return;
        }

        System.out.printf("Customers from city \"%s\" are %n", city);
        customers.forEach(System.out::println);
    }

    static void demo2() {
        int productId = KeyboardUtil.getInt("Enter product id to search: ");
        String sql = "select product_name, category_name, unit_price " +
                "from products natural join categories where product_id=?";
        // the query results in 1 row, multiple columns
        // use the queryForMap from JdbcTemplate
        try {
            Map<String, Object> result = template.queryForMap(sql, productId);
            System.out.println(result);
        } catch (EmptyResultDataAccessException e) {
            System.out.printf("No data found for id %d%n", productId);
        }
    }

    static void demo1() {
        // accept productId from the user and display the product name corresponding to that.
        int productId = KeyboardUtil.getInt("Enter product id to search: ");
        String sql = "select product_name from products where product_id = ?";
        // the query results in 1 row 1 column
        // you can use the queryForObject from JdbcTemplate
        try {
            String productName = template.queryForObject(sql, String.class, productId);
            System.out.printf("Product name for id %d is %s%n", productId, productName);
        } catch (EmptyResultDataAccessException e) {
            System.out.printf("No data found for id %d%n", productId);
        }
    }
}
