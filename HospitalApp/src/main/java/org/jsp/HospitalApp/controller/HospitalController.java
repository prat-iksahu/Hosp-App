package org.jsp.HospitalApp.controller;

import java.util.List;

import org.jsp.HospitalApp.dto.Hospital;
import org.jsp.HospitalApp.service.HospitalService;
import org.jsp.HospitalApp.dto.ResponseStructure;
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
	private HospitalService hospitalService;

	@PostMapping("/hospital")
	public ResponseStructure<Hospital> saveHospital(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}

	@PutMapping("/hospital")
	public ResponseStructure<Hospital> updateHospital(@RequestBody Hospital hospital) {
		return hospitalService.updateHospital(hospital);
	}

	@DeleteMapping("/hospital/{id}")
	public ResponseStructure<String> deleteHospital(@PathVariable int id) {
		return hospitalService.deleteHospital(id);
	}

	@GetMapping("/hospital/{id}")
	public ResponseStructure<Hospital> getHospital(@PathVariable int id) {
		return hospitalService.getHospital(id);
	}

	@GetMapping("/hospital/all")
	public ResponseStructure<List<Hospital>> getAll() {
		return hospitalService.getAll();
	}
}
