package org.jsp.HospitalApp.controller;

import java.util.List;
import org.jsp.HospitalApp.dto.Hospital;
import org.jsp.HospitalApp.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HospitalController {
	
	@Autowired
	private HospitalRepository hospitalRepository;

	@PostMapping("/hospital")
	public Hospital saveHospital(@RequestBody Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	@PutMapping("/hospital")
	public Hospital updateHospital(@RequestBody Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	@DeleteMapping("/hospital/{id}")
	public void deleteHospital(@PathVariable int id) {
		hospitalRepository.deleteById(id);
	}

	@GetMapping("/hospital/{id}")
	public Hospital getHospital(@PathVariable int id) {
		return hospitalRepository.findById(id).get();
	}

	@GetMapping("/hospital/all")
	public List<Hospital> getAll() {
		return hospitalRepository.findAll();
	}
}
