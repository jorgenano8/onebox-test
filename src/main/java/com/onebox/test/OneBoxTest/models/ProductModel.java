package com.onebox.test.OneBoxTest.models;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductModel {

	private int id;
	
	@NotBlank(message = "Description can't be empty.")
	@NotNull(message = "Description can't be NULL.")
	private String description;
	
	@DecimalMin(value="0.0", message = "Amount can't be less than 0.")
	@NotNull(message = "Amount can't be NULL.")
	private Double amount;
	
	private static int countId = 0;
	
	public ProductModel(String description, Double amount) {
		this.id=countId++;
		this.description=description;
		this.amount=amount;
		
	}
	
	public ProductModel(int id, String description, Double amount) {
		this.id=id;
		this.description=description;
		this.amount=amount;
		
	}
	
	public ProductModel() {
		
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
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
