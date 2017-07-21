package com.moraiss.shoppingcart.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RestController;

import com.moraiss.shoppingcart.models.Item;
import com.moraiss.shoppingcart.models.ShoppingCartItem;

@RestController
public class ShoppingCartItemsRepository {
	
	@Autowired
    private JdbcTemplate jtm;
	
	public List<ShoppingCartItem> index() {
        String sql = "SELECT * FROM shoppingcartitems as sci LEFT JOIN items as i ON sci.itemId = i.id";
        List<ShoppingCartItem> cart = jtm.query(sql, new RowMapper<ShoppingCartItem>() {
            public ShoppingCartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
            	ShoppingCartItem cartItem = new ShoppingCartItem();
            	cartItem.setId(Long.parseLong(rs.getString("id")));
            	Item item = new Item(
            						Long.parseLong(rs.getString("itemid")),
            						rs.getString("name"),
            						rs.getString("description"),
            						Float.parseFloat(rs.getString("price"))
            						); 
            	cartItem.setItem(item);
            	cartItem.setQuantity(Integer.parseInt(rs.getString("quantity")));
            	
                return cartItem;
            }
        });
        return cart;
    }
	
	public int save(ShoppingCartItem item) {
		
		return this.jtm.update(
		        "update shoppingcartitems set quantity = ?  where id = ?",
		        item.getQuantity(),
		        item.getId()
		        );
	}

	public int addToCart(Long id) {
		Long cartItemId;
		try {
			String sql = "SELECT sci.id FROM shoppingcartitems as sci LEFT JOIN items as i ON sci.itemId = i.id where i.id=?";
	        cartItemId = jtm.queryForObject(sql, Long.class, id);
		}catch (EmptyResultDataAccessException e) {
			cartItemId = (long) 0;
        }
		
        if(cartItemId != 0) {
        	return this.jtm.update(
    		        "update shoppingcartitems set quantity = quantity+1  where id = ?",
    		        cartItemId
    		        );
        }else {
        	return this.jtm.update(
					"Insert Into shoppingcartitems (itemId, Quantity) VALUES(?,1)",
			        id
			        );
        }
	}

	public int removeFromCart(Long id) {
	
		return this.jtm.update(
				"delete from shoppingcartitems where id = ?",
		        id
		        );
	}
}
