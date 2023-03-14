package com.gcu.service;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.ProductModel;

//AUTHOR: JENNIFER LILES 

public class ProductService {

	static List<ProductModel> products = new ArrayList<>();

	public ProductService() {
		ProductModel product = new ProductModel(null, null, 0, 0, 0);
		addProduct(product);
	}

	public void addProduct(ProductModel product) {
		products.add(product);
	}

	public static List<ProductModel> getProducts() {
		return products;
	}

}