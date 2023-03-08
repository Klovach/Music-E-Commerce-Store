package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.User;

@Controller
public class UserController {

	  private List<User> users = new ArrayList<>(); // store users in memory

	    @GetMapping("/register")
	    public String showRegistrationForm(Model model) {
	        model.addAttribute("user", new User());
	        return "register";
	    }

	    @PostMapping("/register")
	    public String submitRegistrationForm(@ModelAttribute("user") User user, Model model) {
	    	
	    	for (User existingUser : users) {
	    	    if (existingUser.getUsername().equals(user.getUsername())) {
	    	        model.addAttribute("error", "Username already exists");
	    	        return "register";
	    	    }
	    	}

	        // add user to list
	        users.add(user);

	        return "redirect:/login/"; // redirect to login page
	    }
	}