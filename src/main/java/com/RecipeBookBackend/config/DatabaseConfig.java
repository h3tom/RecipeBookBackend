package com.RecipeBookBackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl("jdbc:mysql://eu-cdbr-west-02.cleardb.net/heroku_add31252597c6fd?reconnect=true&serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
