package com.targetindia.config;

import com.targetindia.dao.JdbcShipperDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig3 {

    @Bean
    @Scope("singleton")
    // @Lazy // can be applied only to a singleton bean
    public JdbcShipperDao jdbcShipperDao(){
        return new JdbcShipperDao();
    }

    @Bean
    @Scope("prototype") // by nature, this is lazily loaded
    public JdbcShipperDao shipperDao(){
        return new JdbcShipperDao();
    }
}
