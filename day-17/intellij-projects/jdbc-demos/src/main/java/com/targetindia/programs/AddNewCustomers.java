package com.targetindia.programs;

import com.targetindia.utils.JdbcUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class AddNewCustomers {
    @SneakyThrows
    public static void main(String[] args) {
        String sql = "insert into customers (first_name, last_name, email, phone, city, birth_date) values (?,?,?,?,?,?)";
        try (
                Connection conn = JdbcUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            while(true){
                String firstname = KeyboardUtil.getString("Firstname        : ");
                String lastname = KeyboardUtil.getString("Lastname         : ");
                String email = KeyboardUtil.getString("Email address    : ");
                String phone = KeyboardUtil.getString("Phone number     : ");
                String city = KeyboardUtil.getString("City             : ");
                Date birthDate = KeyboardUtil.getDate("Date of birth    : ");

                stmt.setString(1, firstname);
                stmt.setString(2, lastname);
                stmt.setString(3, email);
                stmt.setString(4, phone);
                stmt.setString(5, city);
                stmt.setDate(6, new java.sql.Date(birthDate.getTime())); // java.sql.Date extends java.util.Date

                try {
                    stmt.executeUpdate(); // carries no SQL command, but only values
                    System.out.println("New customer record was added successfully");
                } catch (SQLException e) {
                    System.err.println("Couldn't add the customer record");
                }

                String ans = KeyboardUtil.getString("Do you want to add another (yes/no): [yes] ");
                if(ans.equalsIgnoreCase("no")){
                    break;
                }
            } // stmt.close(), conn.close() called here automatically
        }
    }
}
