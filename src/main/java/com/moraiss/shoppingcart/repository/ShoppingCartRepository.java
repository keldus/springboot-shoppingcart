package com.moraiss.shoppingcart.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.moraiss.shoppingcart.models.ShoppingCart;

@RestController
public class ShoppingCartRepository {
	
	@Autowired
    private JdbcTemplate jtm;
	
	public ShoppingCart index() {
        String sql = "SELECT * FROM ShoppingCart";
        ShoppingCart cart = jtm.queryForObject(sql, new BeanPropertyRowMapper<ShoppingCart>(ShoppingCart.class));
        
        return cart;
    }
}
