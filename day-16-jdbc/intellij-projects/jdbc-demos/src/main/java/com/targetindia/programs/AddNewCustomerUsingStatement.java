package com.targetindia.programs;

import com.targetindia.utils.DateUtil;
import com.targetindia.utils.JdbcUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

@Slf4j
public class AddNewCustomerUsingStatement {

    @SneakyThrows
    public static void main(String[] args) {
        try (
                Connection conn = JdbcUtil.createConnection();
                Statement stmt = conn.createStatement();
        ) {
            System.out.println("Enter new customer details: ");
            String firstname = KeyboardUtil.getString("Firstname        : ");
            String lastname = KeyboardUtil.getString("Lastname         : ");
            String email = KeyboardUtil.getString("Email address    : ");
            String phone = KeyboardUtil.getString("Phone number     : ");
            String city = KeyboardUtil.getString("City             : ");
            Date birthDate = KeyboardUtil.getDate("Date of birth    : ");

            String sql = "insert into customers (first_name, last_name, email, phone, city, birth_date) values (" +
                    "'%s', '%s', '%s', '%s', '%s', '%s')".formatted(firstname, lastname, email, phone, city, DateUtil.toString(birthDate));
            log.trace("sql = {}", sql);

            int count = stmt.executeUpdate(sql);
            log.trace("{} row/s inserted into customers table", count);

        } // conn.close() & stmt.close() called here automatically
    }
}
