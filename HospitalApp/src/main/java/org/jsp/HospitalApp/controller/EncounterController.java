package org.jsp.HospitalApp.controller;

import java.util.List;

import org.jsp.HospitalApp.dto.Encounter;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.service.EncounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncounterController {
	@Autowired
	EncounterService service;

	@PostMapping("/encounter")
	public ResponseStructure<Encounter> saveEncounter(@RequestBody Encounter encounter) {
		return service.saveEncounter(encounter);
	}

	@PutMapping("/encounter")
	public ResponseStructure<Encounter> updateEncounter(@RequestBody Encounter encounter) {
		
		return service.updateEncounter(encounter);
	}

	@DeleteMapping("/encounter/{id}")
	public ResponseStructure<String> deleteEncounter(@PathVariable int id) {
		return service.deleteEnconter(id);
	}

	@GetMapping("/encounter/{id}")
	public ResponseStructure<Encounter> getEncounter(@PathVariable int id) {
		return service.findEncounter(id);
	}

	@GetMapping("/encounter/all")
	public ResponseStructure<List<Encounter>> getAll()
	{
		return service.findAll() ;
	}
}
