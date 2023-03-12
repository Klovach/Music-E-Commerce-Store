package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.gcu.model.OrderModel;
import com.gcu.service.UserService;

@Controller
@RequestMapping("/store")
public class LoginController {

    @Autowired
    private UserService userService;

    // login POST handler
    @PostMapping("/doLogin")
    public String doLogin(@ModelAttribute("loginModel") LoginModel loginModel, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
    	System.out.println("called do login");
    	if (result.hasErrors()) {
        	System.out.println("result has errors");
            return "login";
        }

        if (userService.isUserExist(loginModel.getUsername(), loginModel.getPassword())) {
        	System.out.println("redirect");
            return "redirect:/store/orders";
        } else {
        	System.out.println("invalid username and password");
            redirectAttributes.addFlashAttribute("error", "Invalid username or password");
            return "redirect:/store/login";
        }
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    // display orders GET handler
    @GetMapping("/orders")
    public String displayOrders(Model model) {
        List<OrderModel> orders = new ArrayList<OrderModel>();
        orders.add(new OrderModel(0L, "00000001", "Product 1", 1.00f, 1));
        orders.add(new OrderModel(1L, "00000002", "Product 2", 2.00f, 2));
        orders.add(new OrderModel(2L, "00000003", "Product 3", 3.00f, 3));
        orders.add(new OrderModel(3L, "00000004", "Product 4", 4.00f, 4));
        orders.add(new OrderModel(4L, "00000005", "Product 5", 5.00f, 5));

        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", orders);
        return "orders";
    } 
} 