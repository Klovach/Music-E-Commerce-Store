package com.gcu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.gcu.service.ProductService;
import com.gcu.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Configuration
public class AppConfig {
	
    @Bean
    @SessionScope
    UserService userService() {
        return new UserService();
    }
    
    // IMPORTANT : If the user is not logged in, redirect them. 
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                HttpSession session = request.getSession(false);
                if (session == null || session.getAttribute("user") == null) {
                    response.sendRedirect("/store/login");
                    return false;
                }
                return true;
            }
        }).addPathPatterns("/create", "/update"); 
    }
    
    @Bean
    ProductService productService() {
    	return new ProductService(); 
    }
}