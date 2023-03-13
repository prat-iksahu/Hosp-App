package org.jsp.HospitalApp.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dto.Address;
import org.jsp.HospitalApp.dto.Admin;
import org.jsp.HospitalApp.dto.Branch;
import org.jsp.HospitalApp.dto.Person;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	@Autowired
	private AdminRepository adminRepository;

	@PostMapping("/admin")
	public ResponseStructure<Admin> saveAdmin(@RequestBody Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setBody(adminRepository.save(admin));
		structure.setMessage("Admin saved successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}

	@PutMapping("/admin")
	public ResponseStructure<Admin> updateAdmin(@RequestBody Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setBody(adminRepository.save(admin));
		structure.setMessage("Admin updated successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}

	@DeleteMapping("/admin/{id}")
	public ResponseStructure<String> deleteAdmin(@PathVariable int id) {
		Optional<Admin> recAdmin = adminRepository.findById(id);
		ResponseStructure<String> structure = new ResponseStructure<String>();
		if (recAdmin.isPresent()) {
			adminRepository.deleteById(id);
			structure.setBody("Admin found");
			structure.setMessage("Admin found and deleted successfully");
			structure.setCode(HttpStatus.FOUND.value());
		} else {
			structure.setBody("Admin Not found");
			structure.setMessage("Unable to delete the Admin");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	@GetMapping("/admin/{id}")
	public ResponseStructure<Admin> findAdminById(@PathVariable int id) {
		Optional<Admin> recAdmin=adminRepository.findById(id);
		ResponseStructure<Admin> structure=new ResponseStructure<Admin>();
		if(recAdmin.isPresent()) {
			structure.setBody(recAdmin.get());
			structure.setMessage("Admin found ");
			structure.setCode(HttpStatus.FOUND.value());
		}
		else {
			structure.setBody(null);
			structure.setMessage("Admin Not Found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	@GetMapping("/admin/all")
	public ResponseStructure<List<Admin>> findAllAdmin() {
		ResponseStructure<List<Admin>> structure=new ResponseStructure<List<Admin>>();
		structure.setBody(adminRepository.findAll());
		structure.setMessage("List of Admin");
		structure.setCode(HttpStatus.FOUND.value());
		return structure;
	}
}
