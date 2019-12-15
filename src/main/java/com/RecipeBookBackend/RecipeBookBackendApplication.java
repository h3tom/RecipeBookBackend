package com.RecipeBookBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@SpringBootApplication
public class RecipeBookBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeBookBackendApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("GET", "POST", "PUT", "DELETE")
						.allowedOrigins("http://localhost:4200");
			}
		};
	}

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
