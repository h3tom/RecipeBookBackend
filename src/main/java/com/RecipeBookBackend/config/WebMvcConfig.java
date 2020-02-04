package com.RecipeBookBackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedOrigins("http://localhost:4200")
                .maxAge(jwtExpirationInMs / 1000);
    }
}
