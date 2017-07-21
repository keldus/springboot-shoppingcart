package com.moraiss.shoppingcart.models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private Long id;
	private List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
	
	public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public List<ShoppingCartItem> getItems() {
        return this.items;
    }
    
    public void addItem(ShoppingCartItem item) {
    	this.items.add(item);
    }
}
