package com.onebox.test.OneBoxTest.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Optional<CartModel> getCartById(@PathVariable int cartId){
		return this.cartService.getCartById(cartId);
	}
	
	@PostMapping
	public void addCart(@RequestBody CartModel cart){
		this.cartService.addCart(cart);
	}
	
	
	@PostMapping(path="/{cartId}")
	public void addProductToCart(@RequestBody ProductModel product, @PathVariable int cartId) {
		this.cartService.addProductToCart(product, cartId);
	}
	

	@PutMapping(path="/{cartId}")
	public void updateProductsToCart(@RequestBody ArrayList<ProductModel> products, @PathVariable int cartId) {
		this.cartService.updateProductsToCart(products, cartId);
	}

	
	@DeleteMapping(path="/{cartId}")
	public void removeCartById(@PathVariable int cartId) {
		this.cartService.removeCartById(cartId);
	}
	
	

}
