package com.targetindia.programs;

import com.targetindia.utils.JdbcUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Slf4j
public class PreventSqlInjection {
    @SneakyThrows
    public static void main(String[] args) {
        String sql = "select * from users where email=? and password=?";

        try (
                Connection conn = JdbcUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql); // 1st round trip to the db server
        ) {
            System.out.println("Enter login details: ");
            String email = KeyboardUtil.getString("Email    : "); // try with this --> ' or 1 limit 1 --
            String password = KeyboardUtil.getString("Password : "); // anything is okay

            // set the values for the parameters in the sql command stored in the PreparedStatement object
            stmt.setString(1, email);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {// carries the parameter values to the server
                if (rs.next()) {
                    System.out.printf("Hello %s %s, Welcome to customer dashboard%n",
                            rs.getString("first_name"),
                            rs.getString("last_name"));
                } else {
                    System.out.println("Invalid username/password. Login failed!");
                }
            }

        } catch (Exception e) {
            log.trace("inside the catch block");
            e.printStackTrace();
        }
    }
}
