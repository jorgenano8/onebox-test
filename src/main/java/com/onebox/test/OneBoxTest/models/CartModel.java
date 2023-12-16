package com.onebox.test.OneBoxTest.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CartModel {
	
	private int id;
	private ArrayList<ProductModel> products;
	private LocalDateTime dateCreation;
	
	private static int countId = 1;
	
	public CartModel(ArrayList<ProductModel> products) {
		this.id=countId++;
		this.products=products;
		this.dateCreation=LocalDateTime.now();
	}

	public CartModel() {
		this.products=new ArrayList<>();
		this.dateCreation=LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public ArrayList<ProductModel> getProducts() {
		return products;
	}
	
	public void addProduct(ProductModel product) {
		this.products.add(product);
	}
	
	/*
	public void addProducts(ArrayList<ProductModel> products) {
		this.products.addAll(products);
	}
	*/

	public void setProducts(ArrayList<ProductModel> products) {
		this.products = products;
	}
	

}
