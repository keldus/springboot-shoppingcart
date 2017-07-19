package com.moraiss.shoppingcart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moraiss.shoppingcart.models.CatalogModel;
import com.moraiss.shoppingcart.repository.Item;



@RestController
@RequestMapping("api/v1")
public class CatalogController {
	
	@Autowired
    private CatalogModel catalogModel;
	
	@RequestMapping(value = "item", method = RequestMethod.GET)
    public List<Item> index() {
		List<Item> items = catalogModel.index();
		
        return items;
    }
	
}
