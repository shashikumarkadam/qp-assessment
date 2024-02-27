package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Model.Order;
import com.example.Model.Product;

@Service
public interface ServiceUser {

	List<Product> getPro();
	Product saveOrder(Order order);
}
