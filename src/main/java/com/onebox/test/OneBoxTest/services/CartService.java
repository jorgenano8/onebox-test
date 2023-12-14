package com.onebox.test.OneBoxTest.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebox.test.OneBoxTest.models.CartModel;
import com.onebox.test.OneBoxTest.models.ProductModel;
import com.onebox.test.OneBoxTest.repositories.ICartRepository;

@Service
public class CartService {
	
	@Autowired
	ICartRepository cartRepository;
	
	public ArrayList<CartModel> getCarts(){
		return (ArrayList<CartModel>) cartRepository.getAllCarts();
	}
	
	public Optional<CartModel> getCartById(int cartId){
		return (Optional<CartModel>) cartRepository.getCartById(cartId);
	}
	
	public void addCart(CartModel cart) {
		this.cartRepository.addCart(cart);
	}
	
	public void addProductToCart(ProductModel product, int cartId) {
		this.cartRepository.addProductToCart(product, cartId);
	}
	
	public void addProductsToCart(ArrayList<ProductModel> products, int cartId) {
		this.cartRepository.addProductsToCart(products, cartId);
	}
	
	public void removeCartById(int cartId) {
		this.cartRepository.removeCartById(cartId);
	}
	
}
