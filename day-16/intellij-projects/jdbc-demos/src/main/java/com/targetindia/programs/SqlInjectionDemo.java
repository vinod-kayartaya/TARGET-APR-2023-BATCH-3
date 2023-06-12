package com.targetindia.programs;

import com.targetindia.utils.JdbcUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlInjectionDemo {

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("Enter login details: ");
        String email = KeyboardUtil.getString("Email    : "); // try with this --> ' or 1 limit 1 --
        String password = KeyboardUtil.getString("Password : "); // anything is okay
        String sql = "select * from users where email='%s' and password='%s'".formatted(email, password);
        try (
                Connection conn = JdbcUtil.createConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            if(rs.next()){
                System.out.printf("Hello %s %s, Welcome to customer dashboard%n",
                        rs.getString("first_name"),
                        rs.getString("last_name"));
            }
            else {
                System.out.println("Invalid username/password. Login failed!");
            }
        } // conn, stmt, and rs get closed here
    }
}
