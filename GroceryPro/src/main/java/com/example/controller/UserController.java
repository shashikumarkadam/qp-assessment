package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Order;
import com.example.Model.Product;
import com.example.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;
	
	
	@GetMapping("/getAll/item")
	public ResponseEntity<List<Product>> getProduct(){
		return new ResponseEntity<List<Product>>(service.getPro(),HttpStatus.OK);
	}
	//add multiple item in single order.
	
	@PostMapping("/add")
    public ResponseEntity<Product> createOrder(@RequestBody Order order) {
      Product response=  service.saveOrder(order);
        if(!ObjectUtils.isEmpty(response)) 
			return new ResponseEntity<Product>(response,HttpStatus.CREATED);
		else
			return new ResponseEntity<Product>(response,HttpStatus.OK);
    }
}
