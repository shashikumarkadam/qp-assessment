package com.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.Model.Order;
import com.example.Model.Product;

@Repository
public class UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Product> getAllItem() {
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

	public Product addOrders(Order order) {
		jdbcTemplate.update("INSERT INTO orders (customer_name, order_date) VALUES (?, ?)",
                order.getCustomerName(), order.getOrderDate());
        Long orderId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);

        for (Product item : order.getProduct()) {
            jdbcTemplate.update("INSERT INTO product (orderid, proid ,proname, procontity, price, totalprice) VALUES (?,?, ?, ?, ?,?)",
                    orderId,item.getProId(), item.getProName(), item.getProContity(), item.getPrice(), item.getTotalPrice());
        }
		return null;
    }		
	}

