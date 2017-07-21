package com.moraiss.shoppingcart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.moraiss.shoppingcart.models.Item;
import com.moraiss.shoppingcart.repository.ItemsRepository;

@RestController
@RequestMapping("/api/v1")
public class ItemsController {
	
	@Autowired
    private ItemsRepository itemsRepo;
	
	@RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Item> index() {
		List<Item> items = itemsRepo.index();
		
        return items;
    }
	
	@RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    public String get(@PathVariable int id) {
		Item item = itemsRepo.get(id);
		Gson g = new Gson();

        return g.toJson(item);
    }
	
}
