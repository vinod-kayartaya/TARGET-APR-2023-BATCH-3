package com.targetindia.config;

import com.targetindia.dao.JdbcShipperDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Slf4j
@Configuration
@PropertySource({"classpath:jdbc-info.properties"}) // loads all the properties from the given filename
@ComponentScan(basePackages = {"com.targetindia.dao"})
// the above annotation instructs Spring to scan the given package/s for components (not just classes) and
// load them in to the spring container. A component is a class decorated with one of the following:
// @Configuration, @Component, @Service, @Repository, @Controller, @RestController
public class AppConfig2 {

    @Bean
    public JdbcDataSource jdbcDataSource(
            @Value("${jdbc.connection.url}") String url,
            @Value("${jdbc.connection.username}") String username,
            @Value("${jdbc.connection.password}") String password) {

        JdbcDataSource jds = new JdbcDataSource();
        jds.setUrl(url);
        jds.setUser(username);
        jds.setPassword(password);
        return jds;
    }

    @Bean
    public BasicDataSource dataSource(
            @Value("${jdbc.connection.driverClassName}") String driverClassName,
            @Value("${jdbc.connection.url}") String url,
            @Value("${jdbc.connection.username}") String username,
            @Value("${jdbc.connection.password}") String password) {

        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }
}
