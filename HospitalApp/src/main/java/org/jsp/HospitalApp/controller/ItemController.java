package org.jsp.HospitalApp.controller;

import java.util.List;

import org.jsp.HospitalApp.dto.Item;
import org.jsp.HospitalApp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	@Autowired
	private ItemRepository itemrepository;

	@PostMapping("/item")
	public Item saveItem(@RequestBody Item item) {
		return itemrepository.save(item);
	}

	@PutMapping("/item")
	public Item updateItem(@RequestBody Item item) {
		return itemrepository.save(item);
	}

	@DeleteMapping("/item/{id}")
	public void deleteItem(@PathVariable int id) {
		itemrepository.deleteById(id);
	}

	@GetMapping("/item/{id}")
	public Item getItem(@PathVariable int id) {
		return itemrepository.findById(id).get();
	}

	@GetMapping("/item/all")
	public List<Item> getAll() {
		return itemrepository.findAll();
	}
}
