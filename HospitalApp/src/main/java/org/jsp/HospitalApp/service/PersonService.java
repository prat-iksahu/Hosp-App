package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.PersonDao;
import org.jsp.HospitalApp.dto.Person;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	@Autowired
	PersonDao dao;

	public ResponseStructure<Person> savePerson(Person person) {
		ResponseStructure<Person> structure=new ResponseStructure<Person>();
		structure.setBody(dao.savePerson(person));
		structure.setMessage("Person saved successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}

	public ResponseStructure<Person> updatePerson(Person person) {
		ResponseStructure<Person> structure=new ResponseStructure<Person>();
		structure.setBody(dao.updatePerson(person));
		structure.setMessage("Person update successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());;
		return structure;
	}

	public ResponseStructure<String> deletePerson(int id) {
		Optional<Person> recPerson=dao.findById(id);
		ResponseStructure<String> structure=new ResponseStructure<String>();
		if(recPerson.isPresent()) {
			dao.deleteById(id);
			structure.setBody("Person found");
			structure.setMessage("Person found and deleted successfully");
			structure.setCode(HttpStatus.FOUND.value());
		}
		else {
			structure.setBody("Person Not found");
			structure.setMessage("Unable to delete the MedOrder");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		
		return structure;
	}

	public ResponseStructure<Person> findPersonById(int id) {
		Optional<Person> recPerson=dao.findById(id);
		ResponseStructure<Person> structure=new ResponseStructure<Person>();
		if(recPerson.isPresent()) {
			structure.setBody(recPerson.get());
			structure.setMessage("Person found ");
			structure.setCode(HttpStatus.FOUND.value());
		}
		else {
			structure.setBody(null);
			structure.setMessage("Person Not Found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	public ResponseStructure<List<Person>> findAllPerson() {
		ResponseStructure<List<Person>> structure=new ResponseStructure<List<Person>>();
		structure.setBody(dao.findAll());
		structure.setMessage("List of Person ");
		structure.setCode(HttpStatus.FOUND.value());
		return structure;
	}

}
