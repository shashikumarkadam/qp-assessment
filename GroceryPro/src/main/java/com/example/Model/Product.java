package com.example.Model;

import java.util.List;

public class Product {

	private Long proId;
	private String proName;
	private Integer proContity;
	private Integer price;
	private Integer totalPrice;
	
	public Long getProId() {
		return proId;
	}
	public void setProId(Long proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Integer getProContity() {
		return proContity;
	}
	public void setProContity(Integer proContity) {
		this.proContity = proContity;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
