package com.moraiss.shoppingcart.models;

public class ShoppingCartItem {

	private Long id;
	private Item item;
	private int quantity;
	
	public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public Item getItem() {
        return this.item;
    }
    
    public void setItem(Item item) {
    	this.item = (item);
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
    	this.quantity = quantity;
    }
}
