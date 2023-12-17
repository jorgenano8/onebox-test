package com.onebox.test.OneBoxTest.models;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ProductModel {

	private Long id;
	
	@NotEmpty(message = "Description can't be empty.")
	@NotNull(message = "Description is mandatory.")
	private String description;
	
	@DecimalMin(value="0.0", message = "Amount can't be less than 0.")
	@NotNull(message = "Amount is mandatory.")
	private Double amount;
	
	private static long countId = 0;
	
	public ProductModel(String description, Double amount) {
		this.id=countId++;
		this.description=description;
		this.amount=amount;
	}
	
	public ProductModel(Long id, String description, Double amount) {
		this.id=id;
		this.description=description;
		this.amount=amount;
		
	}
	
	public ProductModel() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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
