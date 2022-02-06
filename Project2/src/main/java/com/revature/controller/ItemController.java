package com.revature.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.revature.Service.ItemService;
import com.revature.exceptions.ItemNotFoundException;
import com.revature.model.Item;
@RestController("itemController")
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	// get all items
	@CrossOrigin(origins = "*")
	@GetMapping("/getall")
	public ResponseEntity<List<Item>> getAllItems() {
		return new ResponseEntity<>( itemService.getAll(),HttpStatus.OK);
	}
	
	// get items by their id number
	@CrossOrigin(origins = "*")
	@GetMapping(path ="/itemId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> getItemById(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(itemService.getById(id),HttpStatus.OK);
		} catch(ItemNotFoundException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found", e);
		}
	}
	
	// get items by their category id number
	@CrossOrigin(origins = "*")
	@GetMapping(path ="/category/{catId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Item>> getItemsByCategoryId(@PathVariable Integer catId) {
		try {
			
			return new ResponseEntity<>(itemService.getByCategoryId(catId),HttpStatus.OK);
		} catch(RuntimeException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Issue finding items", e);
		}
	}
	//get item by name
	@CrossOrigin(origins = "*")
	@GetMapping("/search/{param}")
	public List<Item> getItemsBySearchParam(@PathVariable String param) {
		return itemService.getBySearchParam(param);
	}
}