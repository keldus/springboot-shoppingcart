package com.moraiss.shoppingcart.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.moraiss.shoppingcart.models.ShoppingCartItem;
import com.moraiss.shoppingcart.repository.ShoppingCartItemsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/v1")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartItemsRepository cartRepo;
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String index() {
		List<ShoppingCartItem> cart = cartRepo.index();
		
		Gson g = new Gson();
        return g.toJson(cart);
    }
	
	@RequestMapping(value = "/cart/update", method = RequestMethod.PUT)
    public String update(@RequestBody ShoppingCartItem shoppingCartItem) {
		int result = cartRepo.save(shoppingCartItem);
		
		Gson g = new Gson();
        return g.toJson(result);
    }
	
	@RequestMapping(value = "/cart/add/{id}", method = RequestMethod.POST)
    public String addToCart(@PathVariable Long id) {
		int result = cartRepo.addToCart(id);
		
		Gson g = new Gson();
        return g.toJson(result);
    }
	
	@RequestMapping(value = "/cart/remove/{id}", method = RequestMethod.DELETE)
    public String removeFromCart(@PathVariable Long id) {
		int result = cartRepo.removeFromCart(id);
		
		Gson g = new Gson();
        return g.toJson(result);
    }
}
