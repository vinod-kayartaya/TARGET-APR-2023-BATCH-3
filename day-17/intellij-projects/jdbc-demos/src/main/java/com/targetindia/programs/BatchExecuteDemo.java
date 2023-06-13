package com.targetindia.programs;

import com.targetindia.utils.DateUtil;
import com.targetindia.utils.JdbcUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

@Slf4j
public class BatchExecuteDemo {
    @SneakyThrows
    public static void main(String[] args) {
        String filename = "customers.csv";
        String sql = "insert into customers (first_name, last_name, email, phone, city, birth_date) values (?,?,?,?,?,?)";
        try (
                Connection conn = JdbcUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                FileReader reader = new FileReader(filename);
                BufferedReader in = new BufferedReader(reader);
        ) {

            // skip reading the header in csv file
            String line = in.readLine();
            while ((line = in.readLine()) != null) {
                String[] fields = line.split(",");
                stmt.setString(1, fields[0]);
                stmt.setString(2, fields[1]);
                stmt.setString(3, fields[2]);
                stmt.setString(4, fields[3]);
                stmt.setString(5, fields[4]);
                Date birthDate = DateUtil.toDate(fields[5]);
                stmt.setDate(6, new java.sql.Date(birthDate.getTime()));
                stmt.addBatch(); // does not carry the values to the server, but keeps all the data in a batch
            }
            stmt.executeBatch(); // all records are sent in batches
            log.trace("Data added to the database table.");

        }// conn, stmt, reader and in get closed here automatically
    }
}
