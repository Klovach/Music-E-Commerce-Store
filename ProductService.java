package com.gcu.service;

import java.util.ArrayList;
import java.util.List;

import com.gcu.products.Product;



public interface ProductService {

		List<Product> getAllProducts();
		void saveProduct(Product product);
		Product getProductById(String id);
		void deleteProductById(String id);
	
	
}