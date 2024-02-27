package com.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import com.example.Model.Product;
import com.java.mapper.ProductMapper;

@Repository
public class GroceryRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	NamedParameterJdbcTemplate parameterJdbcTemplate;

	public Product addProduct(Product product) {
		String query="insert into product values(?,?,?,?,?)";
		 jdbcTemplate.update(query,product.getProId(),product.getProName(),product.getProContity(),
				product.getPrice(),product.getTotalPrice());
		return product;
	}

	public List<Product> getItem() {
		String query="select * from product";
		List<Product> getPro=jdbcTemplate.query(query, new RowMapper<Product>() {

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
			
			
		});
		return getPro;
	}

	public Product getProduct(Integer pid) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("pid", pid);
		List<Product> product = parameterJdbcTemplate
				.query("select * from product where proid =:pid", map, new ProductMapper());
		return product.isEmpty() ? null :  product.get(0);

	}
	
	public void deleteItem(Integer id) {
		jdbcTemplate.update("delete from product where proid= ?", id);
		
	}

	public Integer updateItem(Product id) {
		jdbcTemplate.update(
				"update product set  proname = ? , procontity = ? , price = ? , totalprice = ? where proid = ?",
				id.getProName(), id.getProContity(), id.getPrice(),
				id.getTotalPrice(),id.getProId());
		return null;
	}

	
		
	}

	
	
	

