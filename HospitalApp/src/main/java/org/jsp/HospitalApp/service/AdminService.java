package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.AdminDao;
import org.jsp.HospitalApp.dto.Admin;
import org.jsp.HospitalApp.dto.Person;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
	AdminDao dao;

	public ResponseStructure<Admin> savePerson(Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setBody(dao.saveAdmin(admin));
		structure.setMessage("Admin saved successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}

	public ResponseStructure<Admin> updatePerson(Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setBody(dao.updateAdmin(admin));
		structure.setMessage("Admin update successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		;
		return structure;
	}

	public ResponseStructure<String> deleteAdmin(int id) {
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

	public ResponseStructure<Admin> findPersonById(int id) {
		Optional<Admin> recAdmin = dao.findById(id);
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		if (recAdmin.isPresent()) {
			structure.setBody(recAdmin.get());
			structure.setMessage("Admin found ");
			structure.setCode(HttpStatus.FOUND.value());
		} else {
			structure.setBody(null);
			structure.setMessage("Admin Not Found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	public ResponseStructure<List<Admin>> findAllPerson() {
		ResponseStructure<List<Admin>> structure = new ResponseStructure<List<Admin>>();
		structure.setBody(dao.findAll());
		structure.setMessage("List of Admin ");
		structure.setCode(HttpStatus.FOUND.value());
		return structure;
	}

}
