package com.onebox.test.OneBoxTest.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebox.test.OneBoxTest.models.ProductModel;
import com.onebox.test.OneBoxTest.repositories.IProductRepository;

@Service
public class ProductService {
	
	@Autowired
	IProductRepository productRepository;
	
	public ArrayList<ProductModel> getProducts(){
		return (ArrayList<ProductModel>) productRepository.getAllProducts();
	}
	
	public Optional<ProductModel> getProductById(Long productId){
		return (Optional<ProductModel>) productRepository.getProductById(productId);
	}
	
	public void addProduct(ProductModel product) {
		this.productRepository.addProduct(new ProductModel(product.getDescription(), product.getAmount()));
	}
	
	public void updateProduct(ProductModel product, Long productId) {
		ProductModel productToUpdate = this.getProductById(productId).get();
		
		productToUpdate.setDescription(product.getDescription());
		productToUpdate.setAmount(product.getAmount());
		
	}
	
	public void removeProductById(Long productId) {
		this.productRepository.removeProductById(productId);
	}
	
}
