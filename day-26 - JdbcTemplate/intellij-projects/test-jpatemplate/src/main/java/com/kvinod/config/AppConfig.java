package com.kvinod.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Slf4j
public class AppConfig {

    @Bean
    @Scope("prototype")
    public EntityManager entityManager(EntityManagerFactory factory) {
        return factory.createEntityManager();
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory factory) {
        log.trace("JpaTransactionManager created!");
        return new JpaTransactionManager(factory);
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource) { // DI happening here
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource); // manual wiring
        factory.setPackagesToScan("com.kvinod.entity");
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter()); // JPA provider

        Properties props = new Properties();
        props.setProperty("hibernate.show_sql", "false");
        props.setProperty("hibernate.format_sql", "true");
        factory.setJpaProperties(props);

        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public JdbcDataSource dataSource() {
        log.trace("DataSource created!");
        JdbcDataSource jds = new JdbcDataSource();
        jds.setUrl("jdbc:h2:tcp://localhost/~/northwind");
        jds.setUser("root");
        jds.setPassword("Welcome#123");
        return jds;
    }
}
