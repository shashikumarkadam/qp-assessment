package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.Order;
import com.example.Model.Product;
import com.example.repository.UserRepository;

@Service
public class UserService implements ServiceUser{

	@Autowired
	UserRepository repository;

	@Override
	public List<Product> getPro() {
		// TODO Auto-generated method stub
		return repository.getAllItem();
	}

	@Override
	public Product saveOrder(Order order) {
		Date date=new Date();
		order.setOrderDate(date);
		return repository.addOrders(order);
	}
}
