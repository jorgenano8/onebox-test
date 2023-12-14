package com.onebox.test.OneBoxTest.models;

import java.util.ArrayList;

public class CartModel {
	
	private int id;
	private ArrayList<ProductModel> products;
	
	public CartModel(int id, ArrayList<ProductModel> products) {
		this.id=id;
		this.products=products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<ProductModel> getProducts() {
		return products;
	}
	
	public void addProduct(ProductModel product) {
		this.products.add(product);
	}
	
	public void addProducts(ArrayList<ProductModel> products) {
		this.products.addAll(products);
	}

	public void setProducts(ArrayList<ProductModel> products) {
		this.products = products;
	}
	

}
