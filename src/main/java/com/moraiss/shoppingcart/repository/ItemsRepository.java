package com.moraiss.shoppingcart.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.moraiss.shoppingcart.models.Item;

@Repository
public class ItemsRepository {
	
	@Autowired
    private JdbcTemplate jtm;

	public List<Item> index() {
        String sql = "SELECT * FROM items";
        List<Item> items = jtm.query(sql, new BeanPropertyRowMapper<Item>(Item.class));
        
        return items;
    }
	
	public Item get(int id) {
        String sql = "SELECT * FROM items WHERE id= ?";
        Item item = jtm.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Item>(Item.class));
        
        return item;
    }
}
