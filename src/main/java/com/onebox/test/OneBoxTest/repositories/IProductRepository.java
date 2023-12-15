package com.onebox.test.OneBoxTest.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.onebox.test.OneBoxTest.models.ProductModel;

@Repository
public class IProductRepository {
	private List<ProductModel> productList;
	
	public IProductRepository() {
		productList = new ArrayList<>();
		startProducts();
	}
	
	private void startProducts() {
		this.addProduct(new ProductModel("Bicicleta", 99.90));
		this.addProduct(new ProductModel("Triciclo", 49.90));
		this.addProduct(new ProductModel("Patinete", 29.90));
		this.addProduct(new ProductModel("Patín", 39.90));
		this.addProduct(new ProductModel("Patinete eléctrico", 299.90));
		this.addProduct(new ProductModel("Silla de ruedas", 450.00));
		this.addProduct(new ProductModel("Bicicleta con ruedines", 119.90));
	}
	
	public List<ProductModel> getAllProducts(){
		return this.productList;
	}
	
	public Optional<ProductModel> getProductById(int productId) {
		return this.productList.stream().filter(product -> product.getId() == productId).findFirst();
	}
	
	public void addProduct(ProductModel product) {
		this.productList.add(product);
	}
	
	public void removeProductById(int productId) {
		this.productList.removeIf(product -> product.getId() == productId);
	}
}
