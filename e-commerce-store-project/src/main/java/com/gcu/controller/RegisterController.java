package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String register(LoginModel user, RedirectAttributes redirectAttributes) {
        if (userService.isEmailExist(user.getEmail())) {
            redirectAttributes.addFlashAttribute("errorMessage", "Email already exists");
            System.out.println("User already exists.");
            return "redirect:/register";
        } else {
            userService.addUser(user);
            System.out.println("User registered.");
            return "redirect:/store/login";
        }
    }
}