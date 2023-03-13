package org.jsp.HospitalApp.controller;

import java.util.List;

import org.jsp.HospitalApp.dto.Item;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController 
{
	@Autowired
	ItemService service;

	@PostMapping("/item")
	public ResponseStructure<Item> saveItem(@RequestBody Item item) {
		return service.saveItem(item);
	}

	@PutMapping("/item")
	public ResponseStructure<Item> updateItem(@RequestBody Item item) {
		
		return service.updateItem(item);
	}

	@DeleteMapping("/item/{id}")
	public ResponseStructure<String> deleteItem(@PathVariable int id) {
		return service.deleteItem(id);
	}

	@GetMapping("/item/{id}")
	public ResponseStructure<Item> getItem(@PathVariable int id) {
		return service.findItem(id);
	}

	@GetMapping("/item/all")
	public ResponseStructure<List<Item>> getAll()
	{
		return service.findAll() ;
	}
}
