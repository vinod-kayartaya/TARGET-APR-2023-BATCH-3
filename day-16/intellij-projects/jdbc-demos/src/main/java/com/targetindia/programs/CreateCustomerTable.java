package com.targetindia.programs;

import com.targetindia.utils.JdbcUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.Statement;

@Slf4j
public class CreateCustomerTable {

    @SneakyThrows // converts any checked exception into an unchecked exception
    public static void main(String[] args) {
        try (
                Connection conn = JdbcUtil.createConnection();
                Statement stmt = conn.createStatement();
        ) {
            String sql = "create table customers(\n" +
                    "    id int primary key auto_increment,\n" +
                    "    first_name varchar(25) not null,\n" +
                    "    last_name varchar(25),\n" +
                    "    email varchar(200) unique,\n" +
                    "    phone varchar(15) unique,\n" +
                    "    birth_date date,\n" +
                    "    city varchar(50) default 'Bangalore'\n" +
                    ")";
            stmt.execute(sql);
            log.trace("Table 'customers' created in the database!");
        }// conn.close(), stmt.close() called here automatically
    }
}
