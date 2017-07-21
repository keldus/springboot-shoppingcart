package com.moraiss.shoppingcart.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.moraiss.shoppingcart.models.ShoppingCart;
import com.moraiss.shoppingcart.repository.ShoppingCartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartRepository cartRepo;
	
	@RequestMapping("/cart")
    public ShoppingCart index() {
		ShoppingCart cart = cartRepo.index();
		
        return cart;
    }
}
