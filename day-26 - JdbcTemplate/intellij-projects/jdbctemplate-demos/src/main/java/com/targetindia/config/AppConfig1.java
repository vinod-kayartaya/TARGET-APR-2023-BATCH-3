package com.targetindia.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource({"classpath:jdbc-info.properties"})
@ComponentScan(basePackages = {"com.targetindia.dao"})
public class AppConfig1 {

    @Bean
    public JdbcTemplate template(DataSource dataSource){ // dependency injection
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public BasicDataSource dataSource(
            @Value("${jdbc.connection.driverClassName}") String driverClassName,
            @Value("${jdbc.connection.url}") String url,
            @Value("${jdbc.connection.username}") String username,
            @Value("${jdbc.connection.password}") String password) {
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName(driverClassName);
        bds.setUrl(url);
        bds.setUsername(username);
        bds.setPassword(password);
        return bds;
    }
}
