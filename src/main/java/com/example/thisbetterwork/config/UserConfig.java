package com.example.thisbetterwork.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
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

@Configuration
@EnableJpaRepositories(basePackages = "com.example.thisbetterwork.repositories2.repo", entityManagerFactoryRef = "secondaryEntityManagerFactory", transactionManagerRef = "secondaryTransactionManager")
public class UserConfig {
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource2")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public HikariDataSource secondDataSource() {
        return dataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class)
                .build();
    }

    @Bean(name = "secondaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean lemf = new LocalContainerEntityManagerFactoryBean();
        lemf.setDataSource(secondDataSource());
        lemf.setPackagesToScan("com.example.thisbetterwork.repositories2.entities");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        lemf.setJpaVendorAdapter(vendorAdapter);
        return lemf;
    }

    @Bean(name = "secondaryTransactionManager")
    public PlatformTransactionManager platformTransactionManager(@Qualifier("secondaryEntityManagerFactory") EntityManagerFactory primaryEntityManagerFactory){
        return  new JpaTransactionManager(primaryEntityManagerFactory);
    }
}
