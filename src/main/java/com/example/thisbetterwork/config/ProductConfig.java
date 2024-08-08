package com.example.thisbetterwork.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.thisbetterwork.repositories.repo", entityManagerFactoryRef = "primaryEntityManagerFactory", transactionManagerRef = "primaryTransactionManager")
public class ProductConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource1")
    public DataSourceProperties mainDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public HikariDataSource dataSource() {
        return mainDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class)
                .build();
    }


    @Bean(name = "primaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean lemf = new LocalContainerEntityManagerFactoryBean();
        lemf.setDataSource(dataSource());
        lemf.setPackagesToScan("com.example.thisbetterwork.repositories");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        lemf.setJpaVendorAdapter(vendorAdapter);
        return lemf;
    }

    @Bean(name = "primaryTransactionManager")
    public PlatformTransactionManager platformTransactionManager(@Qualifier("primaryEntityManagerFactory") EntityManagerFactory primaryEntityManagerFactory){
        return  new JpaTransactionManager(primaryEntityManagerFactory);
    }
}
