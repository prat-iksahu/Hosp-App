package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.AdminDao;
import org.jsp.HospitalApp.dto.Admin;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AdminService {
	@Autowired
	AdminDao dao;

	public ResponseStructure<Admin> saveAdmin(@RequestBody Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setBody(dao.saveAdmin(admin));
		structure.setMessage("Admin saved successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}

	public ResponseStructure<Admin> updateAdmin(@RequestBody Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setBody(dao.updateAdmin(admin));
		structure.setMessage("Admin updated successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}

	public ResponseStructure<String> deleteAdmin(@PathVariable int id) {
		Optional<Admin> recAdmin = dao.findById(id);
		ResponseStructure<String> structure = new ResponseStructure<String>();
		if (recAdmin.isPresent()) {
			dao.deleteById(id);
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

	public ResponseStructure<Admin> findAdminById(@PathVariable int id) {
		Optional<Admin> recAdmin=dao.findById(id);
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
	
	public ResponseStructure<List<Admin>> findAllAdmin() {
		ResponseStructure<List<Admin>> structure=new ResponseStructure<List<Admin>>();
		structure.setBody(dao.findAll());
		structure.setMessage("List of Admin");
		structure.setCode(HttpStatus.FOUND.value());
		return structure;
	}
}
