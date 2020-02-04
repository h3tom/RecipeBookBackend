package com.RecipeBookBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://eu-cdbr-west-02.cleardb.net/heroku_add31252597c6fd?reconnect=true&serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8");
        return dataSource;
    }
}
