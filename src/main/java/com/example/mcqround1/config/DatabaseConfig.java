package com.example.mcqround1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("database.properties")
public class DatabaseConfig {
    @Value("${db.url}")
    private String dbUrl;
    @Value("${db.driver-class}")
    private String dbDriverClass;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Bean("datasource")
    public DataSource getDataSource(){
        DriverManagerDataSource d = new DriverManagerDataSource();
        d.setDriverClassName(dbDriverClass);
        d.setUrl(dbUrl);
        d.setUsername(username);
        d.setPassword(password);
        return d;
    }

}