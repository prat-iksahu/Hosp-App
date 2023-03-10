package org.jsp.HospitalApp.controller;

import java.util.List;

import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.dto.Staff;
import org.jsp.HospitalApp.service.StaffService;
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
	StaffService service;
	@PostMapping("/staff")
	public ResponseStructure<Staff> saveStaff(@RequestBody Staff staff) {
		return service.saveStaff(staff);
	}
	@PutMapping("/staff")
	public ResponseStructure<Staff> updateStaff(@RequestBody Staff staff) {
		return service.updateStaff(staff);
	}
	@DeleteMapping("/staff/{id}")
	public ResponseStructure<String> deleteStaff(@PathVariable int id) {
		
		return service.deleteStaff(id);
	}
	@GetMapping("/staff/{id}")
	public ResponseStructure<Staff> findStaffById(@PathVariable int id) {
		return service.findStaffById(id);
	}
	
	@GetMapping("/staff/all")
	public ResponseStructure<List<Staff>> findAllStaff() {
		return service.findAllStaff() ;
	}
}