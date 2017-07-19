package com.moraiss.shoppingcart.models;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.moraiss.shoppingcart.repository.Item;

@Service
public class CatalogModel {
	
	@Autowired
    private JdbcTemplate jtm;

    public List<Item> index() {
        String sql = "SELECT * FROM items";
        List<Item> items = jtm.query(sql, new BeanPropertyRowMapper(Item.class));
        
        return items;
    }
}
