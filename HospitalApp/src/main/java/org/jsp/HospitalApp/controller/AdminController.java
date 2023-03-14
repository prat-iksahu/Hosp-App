package org.jsp.HospitalApp.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dto.Address;
import org.jsp.HospitalApp.dto.Admin;
import org.jsp.HospitalApp.dto.ResponseStructure;

import org.jsp.HospitalApp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	private AdminService service;

	@PostMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return service.saveAdmin(admin);
	}

	@PutMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin) {
		return service.updateAdmin(admin);
	}

	@DeleteMapping("/admin/{id}")
	public  ResponseEntity<ResponseStructure<String>> deleteAdmin(@PathVariable int id) {
		return service.deleteAdmin(id);
	}

	@GetMapping("/admin/{id}")
	public ResponseEntity<ResponseStructure<Admin>> findAdminById(@PathVariable int id) {
		return service.findAdminById(id);
	}

	@GetMapping("/admin/all")
	public ResponseEntity<ResponseStructure<List<Admin>>> findAllAdmin() {
		return service.findAllAdmin();
	}
}
