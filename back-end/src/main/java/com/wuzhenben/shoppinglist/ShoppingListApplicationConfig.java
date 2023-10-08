package com.wuzhenben.shoppinglist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ShoppingListApplicationConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping(
                    "/api/v1/shopping-items/**"
                ).allowedOrigins(
                    "http://localhost:8080" // for production
                        , "http://localhost:5173" // for development
                        , "http://0.0.0.0:8080" // for portainer
                ).allowedMethods(
                    "GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
