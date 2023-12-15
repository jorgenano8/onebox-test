package com.onebox.test.OneBoxTest.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.onebox.test.OneBoxTest.models.CartModel;
import com.onebox.test.OneBoxTest.models.ProductModel;

@Repository
public class ICartRepository {
	private List<CartModel> cartList = new ArrayList<>();
	
	public List<CartModel> getAllCarts(){
		return this.cartList;
	}
	
	public Optional<CartModel> getCartById(int cartId) {
		return this.cartList.stream().filter(cart -> cart.getId() == cartId).findFirst();
	}
	
	public void addCart(CartModel cart) {
		this.cartList.add(cart);
	}
	
	public void addProductToCart(ProductModel product, CartModel cartModel) {
		this.cartList.stream().filter(cart -> cart.getId() == cartModel.getId()).findFirst().get().addProduct(product);
	}
	
	/*
	public void addProductsToCart(ArrayList<ProductModel> products, CartModel cartModel) {
		this.cartList.stream().filter(cart -> cart.getId() == cartModel.getId()).findFirst().get().addProducts(products);
	}
	*/
	
	public void removeCartById(int cartId){
		this.cartList.removeIf(cart -> cart.getId() == cartId);
	}
	
	
}
