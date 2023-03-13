package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.ProductModel;
import com.gcu.products.MusicProducts;
import com.gcu.products.Product;

import jakarta.validation.Valid;

@Controller
public class ProductsController {
	
	//Dependency Injection
	@Autowired
	MusicProducts disProducts;


	
		@GetMapping("/products")
		public String products(Model model) {
				
			List<ProductModel> products = disProducts.getProducts();
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
			
			//Process of adding a new product to the database
			model.addAttribute("newProduct", newProduct);
			//Add to database
			disProducts.addProduct(newProduct);
			
			//Get all products from the database:
			List<ProductModel> products = disProducts.getProducts();
			
			//Show all products on page
			model.addAttribute("products", products);
			
			return "products";
		}
  		
		
	
	
}