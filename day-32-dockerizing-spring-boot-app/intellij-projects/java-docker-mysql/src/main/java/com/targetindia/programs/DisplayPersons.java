package com.targetindia.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayPersons {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:2345/vindb";
        String username = "root";
        String password = "Welcome#123";
        String sql = "select * from persons";

        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            while(rs.next()){
                System.out.printf("%3d %-25s %-50s%n",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        }

    }
}
