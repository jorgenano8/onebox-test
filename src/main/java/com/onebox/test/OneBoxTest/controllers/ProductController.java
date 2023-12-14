package com.onebox.test.OneBoxTest.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onebox.test.OneBoxTest.models.ProductModel;
import com.onebox.test.OneBoxTest.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ArrayList<ProductModel> getProducts(){
		return this.productService.getProducts();
	}
	
	@GetMapping(path="/{productId}")
	public Optional<ProductModel> getProductById(@PathVariable int productId){
		return this.productService.getProductById(productId);
	}
	
	@PostMapping
	public void addProduct(@RequestBody ProductModel product){
		this.productService.addProduct(product);
		
	}
	

}
