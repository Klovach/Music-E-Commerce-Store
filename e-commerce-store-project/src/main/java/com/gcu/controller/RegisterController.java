package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;
import com.gcu.model.RegisterModel;
import com.gcu.service.UserService;

@Controller
@RequestMapping("/store")
public class RegisterController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
    	System.out.println("Entering showRegisterForm() method...");
        model.addAttribute("registerModel", new RegisterModel());
        return "register";
       
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(LoginModel user) {
    	System.out.println("Called response entity.");
        if (userService.isEmailExist(user.getEmail())) {
        	System.out.println("Email already exists.");
            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
        } else {
            userService.addUser(user);
            System.out.println("Register successful.");
            return new ResponseEntity<>("Registration successful", HttpStatus.CREATED);
        }
    }
}