package org.jsp.HospitalApp.controller;
import java.util.List;
import org.jsp.HospitalApp.dto.Person;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	@Autowired
	PersonService service;
	@PostMapping("/person")
	public ResponseStructure<Person> savePerson(@RequestBody Person person) {
		return service.savePerson(person);
	}
	@PutMapping("/person")
	public ResponseStructure<Person> updatePerson(@RequestBody Person person) {
		return service.updatePerson(person);
	}
	@DeleteMapping("/person/{id}")
	public ResponseStructure<String> deletePerson(@PathVariable int id) {
		
		return service.deletePerson(id);
	}
	@GetMapping("/person/{id}")
	public ResponseStructure<Person> findPersonById(@PathVariable int id) {
		return service.findPersonById(id);
	}
	
	@GetMapping("/person/all")
	public ResponseStructure<List<Person>> findAllPerson() {
		return service.findAllPerson() ;
	}
}
