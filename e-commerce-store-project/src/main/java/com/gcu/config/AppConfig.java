package com.gcu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.service.ProductService;
import com.gcu.service.UserService;

@Configuration
public class AppConfig {
    @Bean
    UserService userService() {
        return new UserService();
    }
    @Bean
    ProductService productService() {
    	return new ProductService(); 
    }
}