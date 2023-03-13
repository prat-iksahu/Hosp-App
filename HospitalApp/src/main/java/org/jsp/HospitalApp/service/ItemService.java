package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.ItemDao;
import org.jsp.HospitalApp.dto.Item;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class ItemService 
{
	@Autowired
	ItemDao dao;

	public ResponseStructure<Item> saveItem(Item item) {
		ResponseStructure<Item> structure=new ResponseStructure<Item>();
		structure.setBody(dao.saveItem(item));
		structure.setMessage("Item saved successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}

	public ResponseStructure<Item> updateItem(Item item) {
		ResponseStructure<Item> structure=new ResponseStructure<Item>();
		structure.setBody(dao.updateItem(item));
		structure.setMessage("Encounter Updated successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}

	
	public ResponseStructure<String> deleteItem(int id) {
		Optional<Item> recItem=dao.findById(id);
		ResponseStructure<String> structure=new ResponseStructure<String>();
		if(recItem.isPresent()) {
			dao.deleteById(id);
			structure.setBody("Item found");
			structure.setMessage("Item found and deleted successfully");
			structure.setCode(HttpStatus.FOUND.value());
		}
		else {
			structure.setBody("Item Not found");
			structure.setMessage("Unable to delete the Item");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		
		return structure;
	}

	public ResponseStructure<Item> findItem(int id) {
		Optional<Item> recItem=dao.findById(id);
		ResponseStructure<Item> structure=new ResponseStructure<Item>();
		if(recItem.isPresent()) {
			structure.setBody(recItem.get());
			structure.setMessage("Item found ");
			structure.setCode(HttpStatus.FOUND.value());
		}
		else {
			structure.setBody(null);
			structure.setMessage("Item Not Found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	public ResponseStructure<List<Item>> findAll() {
		ResponseStructure<List<Item>> structure=new ResponseStructure<List<Item>>();
		structure.setBody(dao.findAll());
		structure.setMessage("List of Item ");
		structure.setCode(HttpStatus.FOUND.value());
		return structure;
	}
}
