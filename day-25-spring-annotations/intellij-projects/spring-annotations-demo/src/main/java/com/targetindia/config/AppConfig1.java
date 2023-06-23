package com.targetindia.config;

import com.targetindia.dao.JdbcShipperDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Slf4j
@Configuration
@PropertySource({"classpath:jdbc-info.properties"}) // loads all the properties from the given filenmae
public class AppConfig1 {
    public AppConfig1() {
        log.trace("AppConfig1 constructor called");
    }

    // Since this class is used as a configuration class for spring container, spring, during the container creation
    // scans this class for any method decorated with @Bean, invokes all of them, collects the return value from
    // each of those methods and keeps them in the spring container. By default, the name of the method is going to be'
    // the name of the bean in the container, but can be explicitly set using the @Bean(name={"..", ".."}).
    // If a @Bean method has one or more arguments, then it is spring's responsibility to pass (inject) a value for
    // the same. However, if spring is unable to determine what value to be passed, it will throw an exception.

    @Bean
    public BasicDataSource dataSource(
            @Value("${jdbc.connection.driverClassName}") String driverClassName,
            @Value("${jdbc.connection.url}") String url,
            @Value("${jdbc.connection.username}") String username,
            @Value("${jdbc.connection.password}") String password){

        log.trace("AppConfig1.dataSource() called with arguments - {}, {}, {}, {}",
                driverClassName, url, username, password);

        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);

        ds.setInitialSize(5);
        ds.setMaxTotal(50);
        ds.setMinIdle(2);
        ds.setMaxIdle(5);
        ds.setMaxWaitMillis(1000);

        return ds;
    }

    @Bean
    public JdbcShipperDao shipperDao(DataSource dataSource){ // dependency injection
        log.trace("AppConfig1.shipperDao() called with argument of type {}", dataSource.getClass().getName());
        return new JdbcShipperDao(dataSource); // manual wiring
    }
}
