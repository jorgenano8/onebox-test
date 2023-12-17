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

import com.onebox.test.OneBoxTest.models.CartModel;
import com.onebox.test.OneBoxTest.models.ProductModel;
import com.onebox.test.OneBoxTest.services.CartService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping
	public ArrayList<CartModel> getCarts(){
		return this.cartService.getCarts();
	}
	
	@GetMapping(path="/{cartId}")
	public Optional<CartModel> getCartById(@PathVariable Long cartId){
		return this.cartService.getCartById(cartId);
	}
	
	@PostMapping
	public ResponseEntity<String> addCart(@Valid @RequestBody CartModel cart, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>("Error creating new cart. Check the fields.", HttpStatus.BAD_REQUEST);
		}
		
		this.cartService.addCart(cart);
		return new ResponseEntity<>("Cart successfully created.", HttpStatus.OK);
	}
	
	
	@PostMapping(path="/{cartId}")
	public ResponseEntity<String> addProductToCart(@Valid @RequestBody ProductModel product, BindingResult bindingResult, @PathVariable Long cartId) {
		if(bindingResult.hasErrors() || product.getId()==null || this.cartService.getCartById(cartId).isEmpty()) {
			return new ResponseEntity<>("Error adding product to cart. Check the fields.", HttpStatus.BAD_REQUEST);
		}
		this.cartService.addProductToCart(product, cartId);
		return new ResponseEntity<>("Product successfully added to cart.", HttpStatus.OK);
	}
	

	@PutMapping(path="/{cartId}")
	public ResponseEntity<String> updateProductsToCart(@PathVariable Long cartId, @Valid @RequestBody ArrayList<ProductModel> products, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>("Error updating products in a cart. Check the fields.", HttpStatus.BAD_REQUEST);
		}
		this.cartService.updateProductsToCart(products, cartId);
		return new ResponseEntity<>("Cart successfully updated with products.", HttpStatus.OK);
	}

	
	@DeleteMapping(path="/{cartId}")
	public void removeCartById(@PathVariable Long cartId) {
		this.cartService.removeCartById(cartId);
	}
	
}
