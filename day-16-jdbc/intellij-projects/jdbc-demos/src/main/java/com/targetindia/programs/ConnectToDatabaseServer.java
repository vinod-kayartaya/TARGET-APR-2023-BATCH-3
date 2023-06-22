package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j
public class ConnectToDatabaseServer {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/targetdb_b3"; // defaults to port 3306
        String user = "root";
        String password = "Welcome#123";

        try (
                Connection conn = DriverManager.getConnection(url, user, password)
                // in the above statement, the getConnection method checks if the URL given
                // is acceptable by any of these loaded driver objects:
                // oracle.jdbc.OracleDriver
                // com.mysql.cj.jdbc.Driver
                // org.postgresql.Driver
                // org.sqlite.JDBC
                // org.h2.Driver
                // com.microsoft.sqlserver.jdbc.SQLServerDriver

                // if any one of them returns true for acceptsURL(url), then,
                // DriverManager asks that driver object to create a connection, which then will be
                // returned to the variable conn
        ) {
            log.trace("conn is an instanceof '{}' class", conn.getClass().getName());
        } // conn.close() called here automatically
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
