package com.onebox.test.OneBoxTest.models;

import java.util.ArrayList;

public class CartModel {
	
	private int id;
	private ArrayList<ProductModel> products;
	
	private static int countId = 1;
	
	public CartModel(ArrayList<ProductModel> products) {
		this.id=countId++;
		this.products=products;
	}

	public CartModel() {
		this.products=new ArrayList<>();
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
	
	/*
	public void addProducts(ArrayList<ProductModel> products) {
		this.products.addAll(products);
	}
	*/

	public void setProducts(ArrayList<ProductModel> products) {
		this.products = products;
	}
	

}
