package com.onebox.test.OneBoxTest.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onebox.test.OneBoxTest.models.ProductModel;
import com.onebox.test.OneBoxTest.services.ProductService;

import jakarta.validation.Valid;

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
	public Optional<ProductModel> getProductById(@PathVariable Long productId){
		return this.productService.getProductById(productId);
	}
	
	@PostMapping
	public ResponseEntity<String> addProduct(@Valid @RequestBody ProductModel product, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>("Error creating product. Check the fields. " + bindingResult.getFieldError().getDefaultMessage() , HttpStatus.BAD_REQUEST);
		}
		
		this.productService.addProduct(product);
		return new ResponseEntity<>("Product successfully created.", HttpStatus.OK);
	}
	
	@PutMapping(path="/{productId}")
	public ResponseEntity<String> updateProduct(@PathVariable Long productId, @Valid @RequestBody ProductModel product, BindingResult bindingResult) {
		if(bindingResult.hasErrors() || this.productService.getProductById(productId).isEmpty()) {
			return new ResponseEntity<>("Error updating product. Check the fields. " + bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
		this.productService.updateProduct(product, productId);
		return new ResponseEntity<>("Product successfully updated.", HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{productId}")
	public void removeProductbyId(@PathVariable Long productId) {
		this.productService.removeProductById(productId);
	}

}
