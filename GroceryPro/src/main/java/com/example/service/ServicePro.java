package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Model.Product;

@Service
public interface ServicePro {

	 Product addNewPro(Product product);
	 List<Product> getPro();
	 void deleteProduct(Integer id);
	 Product getItem(Integer id);
	 Integer updateItem(Product id);
}
