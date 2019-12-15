package com.RecipeBookBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://eu-cdbr-west-02.cleardb.net/heroku_add31252597c6fd?reconnect=true&serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8");
        dataSource.setUsername("b5cfa3c5452d52");
        dataSource.setPassword("ba46de3a");
        return dataSource;
    }

}
