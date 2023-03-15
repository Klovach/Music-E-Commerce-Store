package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gcu.model.LoginModel;
import com.gcu.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/store")
public class LoginController {

    @Autowired
    private UserService userService;

    /*doLogin
     * The @PostMapping("/doLogin") annotation maps the HTTP POST request from the login form to the 
     * doLogin() method. This method takes in the LoginModel object submitted in the form, 
     * a BindingResult object that checks for validation errors, a Model object that stores data for the view, 
     * a RedirectAttributes object that stores data to be used after a redirect, and a HttpSession object 
     * that stores session data.
     */
    @PostMapping("/doLogin")
    public String doLogin(@ModelAttribute("loginModel") LoginModel loginModel, BindingResult result, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
    	 // If there are errors, return to the login page.
    	if (result.hasErrors()) {
            return "login";
        }
    	 // Check if the user exists in the system. 
        if (userService.isUserExist(loginModel.getUsername(), loginModel.getPassword())) {
        	 // Set the user name in the session and redirect to the create page.
            session.setAttribute("user", loginModel.getUsername());
            return "redirect:/create";
        } else {
        	 // If the user does not exist, add an error message and redirect to the login page.
            redirectAttributes.addFlashAttribute("error", "Invalid username or password");
            return "redirect:/store/login";
        }
    }

    /*showLoginForm(Model model) 
     * This method handles the HTTP GET request for displaying the login page.
     */
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }
    
    /*logout
     * This method will log the user out by invalidating the httpSession. 
     * This method handles the HTTP GET request for logout. 
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/store/login";
    }
} 