package org.jsp.HospitalApp.controller;

import java.util.List;

import org.jsp.HospitalApp.dto.Staff;
import org.jsp.HospitalApp.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {
	@Autowired
	private StaffRepository staffRepository;

	@PostMapping("/staff")
	public Staff saveStaff(@RequestBody Staff staff) {
		return staffRepository.save(staff);
	}

	@PutMapping("/staff")
	public Staff updateStaff(@RequestBody Staff staff) {
		return staffRepository.save(staff);
	}

	@DeleteMapping("/staff/{id}")
	public void deleteStaff(@PathVariable int id) {
		staffRepository.deleteById(id);
	}

	@GetMapping("/staff/{id}")
	public Staff getStaff(@PathVariable int id) {
		return staffRepository.findById(id).get();
	}

	@GetMapping("/staff/all")
	public List<Staff> getAll() {
		return staffRepository.findAll();
	}
}
