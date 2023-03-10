package org.jsp.HospitalApp.controller;

import java.util.List;

import org.jsp.HospitalApp.dto.Encounter;
import org.jsp.HospitalApp.repository.EncounterRepository;
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
	private EncounterRepository encounterrepository;

	@PostMapping("/encounter")
	public Encounter saveEncounter(@RequestBody Encounter encounter) {
		return encounterrepository.save(encounter);
	}

	@PutMapping("/encounter")
	public Encounter updateEncounter(@RequestBody Encounter encounter) {
		return encounterrepository.save(encounter);
	}

	@DeleteMapping("/encounter/{id}")
	public void deleteEncounter(@PathVariable int id) {
		encounterrepository.deleteById(id);
	}

	@GetMapping("/encounter/{id}")
	public Encounter getEncounter(@PathVariable int id) {
		return encounterrepository.findById(id).get();
	}

	@GetMapping("/encounter/all")
	public List<Encounter> getAll() {
		return encounterrepository.findAll();
	}
}
