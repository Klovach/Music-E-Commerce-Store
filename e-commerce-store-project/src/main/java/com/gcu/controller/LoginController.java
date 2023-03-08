package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

	
	@GetMapping("/")
	public String Display(Model model)
	{
		//Set the title attribute to Login Form 
		model.addAttribute("title", "Login Form");
		//Add the login model. 
		model.addAttribute("loginModel", new LoginModel());
		
		//Return the name of the view. 
		return "login"; 
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) 
	{
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login"; 
		}
		//Print the form values.
		
		//Create some orders
		List<OrderModel> orders = new ArrayList<OrderModel>();
		orders.add(new OrderModel(0L, "00000001", "Product 1", 1.00f, 1));
		orders.add(new OrderModel(1L, "00000002", "Product 2", 2.00f, 2));
		orders.add(new OrderModel(2L, "00000003", "Product 3", 3.00f, 3));
		orders.add(new OrderModel(3L, "00000004", "Product 4", 4.00f, 4));
		orders.add(new OrderModel(4L, "00000005", "Product 5", 5.00f, 5));
		
		
		//System.out.println(String.format("Orders with values of %d %s %s %f %d", orderModel.getId(), orderModel.getOrderNo(), orderModel.getProductName(), orderModel.getPrice(), orderModel.getQuantity()));
		//Navigate back to the Login view.
		//Set title and order model
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", orders);
		return "orders";
		//return "login";
		
	}
	
}
