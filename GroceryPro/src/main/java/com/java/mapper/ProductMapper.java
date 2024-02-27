package com.java.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.Model.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product=new Product();
		product.setProId(rs.getLong("proid"));
		product.setProName(rs.getString("proname"));
		product.setProContity(rs.getInt("procontity"));
		product.setPrice(rs.getInt("price"));
		product.setTotalPrice(rs.getInt("totalprice"));
		return product;
	
	}

}
