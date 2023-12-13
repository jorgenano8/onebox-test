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
	
	public Optional<ProductModel> getProductById(int productId){
		return (Optional<ProductModel>) productRepository.getProductById(productId);
	}
	
	

}
