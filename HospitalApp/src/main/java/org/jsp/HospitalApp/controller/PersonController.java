package org.jsp.HospitalApp.controller;

import java.util.List;

import org.jsp.HospitalApp.dto.Person;
import org.jsp.HospitalApp.repository.PersonRepository;
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
	private PersonRepository personRepository;

	@PostMapping("/person")
	public Person savePerson(@RequestBody Person person) {
		return personRepository.save(person);
	}

	@PutMapping("/person")
	public Person updatePerson(@RequestBody Person person) {
		return personRepository.save(person);
	}

	@DeleteMapping("/person/{id}")
	public void deletePerson(@PathVariable int id) {
		personRepository.deleteById(id);
	}

	@GetMapping("/person/{id}")
	public Person getBranch(@PathVariable int id) {
		return personRepository.findById(id).get();
	}

	@GetMapping("/person/all")
	public List<Person> getAll() {
		return personRepository.findAll();
	}
}
