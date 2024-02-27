package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Product;
import com.example.service.ProService;

@RestController
@RequestMapping("/admin")
public class GroceryController {

	@Autowired
	ProService service;
	
	//this is admin post request add the product details via admin.
	@PostMapping(path="/item/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		
		Product response= service.addNewPro(product);
		if(!ObjectUtils.isEmpty(response)) 
			return new ResponseEntity<Product>(response,HttpStatus.CREATED);
		else
			return new ResponseEntity<Product>(response,HttpStatus.BAD_REQUEST);
	}
	
	// get all product in list.
	@GetMapping("/getAll/item")
	public ResponseEntity<List<Product>> getProduct(){
		return new ResponseEntity<List<Product>>(service.getPro(),HttpStatus.OK);
	}
	
	// get product enter particular id
	@GetMapping("/get/item/{id}")
	public ResponseEntity<Product> getUpdate(@PathVariable("id") Integer id){
		Product product=service.getItem(id);
		if(!ObjectUtils.isEmpty(product)) 
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		else
			return new ResponseEntity<Product>(product,HttpStatus.NOT_FOUND);

	}
	
	// delete product as particular id
	@DeleteMapping("/item/delete/{id}")
	public void deleteItem(@PathVariable("id") Integer id){
		service.deleteProduct(id);
	}
	
	// update product as mention productId
	@PutMapping("/update/item")
	public ResponseEntity<Integer> updateItem(@RequestBody Product id){
		Integer product=service.updateItem(id);
		if(!ObjectUtils.isEmpty(product)) 
			return new ResponseEntity<Integer>(HttpStatus.OK);
		else
			return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);

		
	}
	
	
}
