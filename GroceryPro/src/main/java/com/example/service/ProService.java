package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.Product;
import com.example.repository.GroceryRepository;

@Service
public class ProService implements ServicePro {

	@Autowired
	GroceryRepository repository;
	
	@Override
	public Product addNewPro(Product product) {
		//this business logic of total price automatic calculate and feel the total price
		
		int total =  (product.getPrice() * product.getProContity());
		product.setTotalPrice(total);
		return repository.addProduct(product);
	}
	
	@Override
	public List<Product> getPro() {
		// TODO Auto-generated method stub
		return repository.getItem();
	}
	
	@Override
	public void deleteProduct(Integer id) {
		repository.deleteItem(id);
		
	}

	@Override
	public Product getItem(Integer id) {
		return repository.getProduct(id);
	}

	@Override
	public Integer updateItem(Product id) {
		return repository.updateItem(id);
	}

	

}
