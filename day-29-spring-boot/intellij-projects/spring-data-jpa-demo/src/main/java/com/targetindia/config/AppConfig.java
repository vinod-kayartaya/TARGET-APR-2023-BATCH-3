package com.targetindia.config;

import jakarta.persistence.EntityManagerFactory;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = {"com.targetindia.dao"})
public class AppConfig {

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory factory){
        return new JpaTransactionManager(factory);
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource ds){
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(ds);
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        bean.setPackagesToScan("com.targetindia.entity");
        bean.afterPropertiesSet();

        return bean.getObject();
    }

    @Bean
    public DataSource dataSource(){
        JdbcDataSource ds = new JdbcDataSource();
        ds.setUrl("jdbc:h2:tcp://localhost/~/northwind");
        ds.setUser("root");
        ds.setPassword("Welcome#123");
        return ds;
    }
}
