package com.targetindia.programs;

import java.sql.DriverManager;

public class ListJdbcDrivers {
    public static void main(String[] args) {

        System.out.println("List of jdbc drivers available:");
        DriverManager.drivers()
                .forEach(d -> System.out.println(d.getClass().getName()));
        System.out.println("------------------------");

    }
}
