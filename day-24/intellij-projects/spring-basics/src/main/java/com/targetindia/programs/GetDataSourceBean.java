package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Slf4j
public class GetDataSourceBean {
    public static void main(String[] args) throws Exception{
        // a variable to represent a spring container
        ClassPathXmlApplicationContext ctx;

        // create a spring container, by supplying the configuration file
        ctx = new ClassPathXmlApplicationContext("config1.xml");

        // a variable that I want to use
        DataSource ds;

        // get it from the spring container
        ds = ctx.getBean(DataSource.class);
        log.trace("ds is an instanceof {} class", ds.getClass().getName());

        // use the dataSource to get a connection
        Connection conn = ds.getConnection();
        log.trace("conn is an instanceof {} class", conn.getClass().getName());

        Statement stmt = conn.createStatement();
        log.trace("stmt is an instanceof {} class", stmt.getClass().getName());

        ResultSet rs = stmt.executeQuery("select * from shippers");
        log.trace("rs is an instanceof {} class", rs.getClass().getName());

        while(rs.next()){
            System.out.printf("%2d %-30s %-15s%n",
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
        }
    }
}
