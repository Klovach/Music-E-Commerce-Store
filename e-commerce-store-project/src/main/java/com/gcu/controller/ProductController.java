package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.ProductModel;
import com.gcu.service.ProductService;

//AUTHOR: JENNIFER LILES 

@Controller
public class ProductController {

	// Dependency Injection
	// Note: This area is reserved for Joe and Paula. You will have to re-write this so that the product page is displayed correctly. 
	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public String products(Model model) {

		List<ProductModel> products = ProductService.getProducts();
		model.addAttribute("products", products);
		return "products";
	}

	@GetMapping("/addaproduct")
	public String addProduct(Model model) {
		model.addAttribute("newProduct", new ProductModel("", "", 0, 0, 0));
		return "addaproduct";
	}

	@PostMapping("/addaproduct")
	public String createNewProduct(@ModelAttribute ProductModel newProduct, Model model) {

		// Process of adding a new product to the database
		model.addAttribute("newProduct", newProduct);
		// Add to database
		productService.addProduct(newProduct);

		// Get all products from the database:
		List<ProductModel> products = ProductService.getProducts();

		// Show all products on page
		model.addAttribute("products", products);

		return "products";
	}

}