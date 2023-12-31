package com.onebox.test.OneBoxTest.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
	
	public Optional<CartModel> getCartById(Long cartId){
		return (Optional<CartModel>) cartRepository.getCartById(cartId);
	}
	
	public void addCart(CartModel cart) {
		CartModel newCartModel;
		if(cart.getProducts()!=null) {
			newCartModel = new CartModel(cart.getProducts());
		}else {
			newCartModel = new CartModel();
		}
		
		this.cartRepository.addCart(newCartModel);
	}
	
	public void addProductToCart(ProductModel product, Long cartId) {
		ProductModel newProductToCart = new ProductModel(product.getId(), product.getDescription(), product.getAmount());
		this.cartRepository.addProductToCart(newProductToCart, this.cartRepository.getCartById(cartId).get());

	}
	
	public void updateProductsToCart(ArrayList<ProductModel> products, Long cartId) {
		if(this.cartRepository.getCartById(cartId).get()!=null) {
			ArrayList<ProductModel> newProducts = new ArrayList<>();
			products.forEach((product) -> {
				newProducts.add(new ProductModel(product.getId(), product.getDescription(), product.getAmount()));
			});
			this.cartRepository.updateProductsToCart(newProducts, this.cartRepository.getCartById(cartId).get());
		}
	}

	public void removeCartById(Long cartId) {
		this.cartRepository.removeCartById(cartId);
	}
	@Scheduled(fixedDelay=1000)
	public void scheduledRemoveCart() {
		this.cartRepository.scheduledRemoveCart();
	}
	
}
