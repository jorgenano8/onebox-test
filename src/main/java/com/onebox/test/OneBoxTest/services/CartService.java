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
		if(cart.getProducts()!=null) {
			this.cartRepository.addCart(new CartModel(cart.getProducts()));
		}else {
			this.cartRepository.addCart(new CartModel());
		}
	}
	
	public void addProductToCart(ProductModel product, int cartId) {
		ProductModel newProductToCart = new ProductModel(product.getId(), product.getDescription(), product.getAmount());

		this.cartRepository.addProductToCart(newProductToCart, this.cartRepository.getCartById(cartId).get());
	}
	
	/*
	public void addProductsToCart(ArrayList<ProductModel> products, int cartId) {
		if(this.cartRepository.getCartById(cartId).get()!=null) {
			ArrayList<ProductModel> newProducts = new ArrayList<>();
			products.forEach((product) -> newProducts.add(new ProductModel(product.getId(), product.getDescription(), product.getAmount())));
			this.cartRepository.addProductsToCart(newProducts, this.cartRepository.getCartById(cartId).get());
		}
	}
	*/

	
	public void removeCartById(int cartId) {
		this.cartRepository.removeCartById(cartId);
	}
	
}
