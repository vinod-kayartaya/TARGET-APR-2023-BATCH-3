package com.targetindia.programs;

import com.targetindia.utils.DateUtil;
import com.targetindia.utils.JdbcUtil;
import com.targetindia.utils.KeyboardUtil;
import com.targetindia.utils.LineUtil;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class SearchCustomerByEmailOrPhone {
    @SneakyThrows
    public static void main(String[] args) {
        String emailOrPhone= KeyboardUtil.getString("Enter email or phone to search customer: ");
        String sql = "select * from customers where email=? or phone=?";
        try (
                Connection conn = JdbcUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, emailOrPhone);
            stmt.setString(2, emailOrPhone);
            try (ResultSet rs = stmt.executeQuery()) {
                if(rs.next()){
                    int id = rs.getInt("id");
                    String firstname = rs.getString("first_name");
                    String lastname = rs.getString("last_name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String city = rs.getString("city");
                    Date birthDate = rs.getDate("birth_date");

                    System.out.println("Customer data:");
                    LineUtil.line(50);
                    System.out.printf("Id                : %s%n", id);
                    System.out.printf("Name              : %s %s%n", firstname, lastname);
                    System.out.printf("City              : %s%n", city);
                    System.out.printf("Email address     : %s%n", city);
                    System.out.printf("Phone number      : %s%n", city);
                    System.out.printf("Date of birth     : %s%n", DateUtil.toString(birthDate));
                    LineUtil.line(50);
                }
                else {
                    System.out.printf("No customer found for email or phone as %s%n", emailOrPhone);
                }
            }// rs.close() called here

        } // stmt.close(), conn.close() called here
    }
}
