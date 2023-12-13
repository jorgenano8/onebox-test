package com.onebox.test.OneBoxTest.models;

public class ProductModel {

	private int id;
	private String description;
	private double amount;
	
	public ProductModel(int id, String description, double amount) {
		this.id=id;
		this.description=description;
		this.amount=amount;
		
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}