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

public class GetCustomersFromCity {
    @SneakyThrows
    public static void main(String[] args) {

        String city = KeyboardUtil.getString("Enter city to search customers from: ");
        String sql = "select * from customers where lower(city)=lower(?)";

        try (
                Connection conn = JdbcUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {

            stmt.setString(1, city);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    System.out.printf("Customer list from the city of %s: %n", city);
                    System.out.printf("%4s %-25s %-35s %-10s %-10s%n",
                            "Id", "Name", "Email address", "Phone", "D.O.B.");
                    LineUtil.line("=");
                    do {
                        int id = rs.getInt("id");
                        String firstname = rs.getString("first_name");
                        String lastname = rs.getString("last_name");
                        String email = rs.getString("email");
                        String phone = rs.getString("phone");
                        Date birthDate = rs.getDate("birth_date");

                        System.out.printf("%4s %-25s %-35s %-10s %-10s%n",
                                id, firstname + " " + lastname, email, phone,
                                DateUtil.toString(birthDate)
                                );

                    } while (rs.next());
                    LineUtil.line("~");
                } else {
                    System.out.printf("No customers exist in the city of %s%n", city);
                }

            } // rs.close() called here

        } // stmt.close(), conn.close() called here
    }

}
