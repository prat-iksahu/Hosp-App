package org.jsp.HospitalApp.controller;

import java.util.List;

import org.jsp.HospitalApp.dto.Address;
import org.jsp.HospitalApp.dto.Admin;
import org.jsp.HospitalApp.dto.Branch;
import org.jsp.HospitalApp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
	public Admin saveAdmin(@RequestBody Admin admin) {
		System.out.print(admin.getName());
		return adminRepository.save(admin);
	}

	@PutMapping("/admin")
	public Admin updateAdmin(@RequestBody Admin admin) {
		return adminRepository.save(admin);
	}

	@DeleteMapping("/admin/{id}")
	public void deleteAdmin(@PathVariable int id) {
		adminRepository.deleteById(id);
	}

	@GetMapping("/admin/{id}")
	public Admin getAdmin(@PathVariable int id) {
		return adminRepository.findById(id).get();
	}

	@GetMapping("/admin/all")
	public List<Admin> getAll() {
		return adminRepository.findAll();
	}

}
