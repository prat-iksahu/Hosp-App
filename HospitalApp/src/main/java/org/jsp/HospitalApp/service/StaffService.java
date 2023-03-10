package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.StaffDao;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.dto.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
@Service
public class StaffService {
	@Autowired
	StaffDao dao;

	public ResponseStructure<Staff> saveStaff(Staff staff) {
		ResponseStructure<Staff> structure=new ResponseStructure<Staff>();
		structure.setBody(dao.saveStaff(staff));
		structure.setMessage("Staff saved successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}

	public ResponseStructure<Staff> updateStaff(Staff staff) {
		ResponseStructure<Staff> structure=new ResponseStructure<Staff>();
		structure.setBody(dao.updateStaff(staff));
		structure.setMessage("Staff update successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());;
		return structure;
	}

	
	public ResponseStructure<String> deleteStaff(int id) {
		Optional<Staff> recStaff=dao.findById(id);
		ResponseStructure<String> structure=new ResponseStructure<String>();
		if(recStaff.isPresent()) {
			dao.deleteById(id);
			structure.setBody("Staff found");
			structure.setMessage("Staff found and deleted successfully");
			structure.setCode(HttpStatus.FOUND.value());
		}
		else {
			structure.setBody("Staff Not found");
			structure.setMessage("Unable to delete the Staff");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		
		return structure;
	}

	public ResponseStructure<Staff> findStaffById(int id) {
		Optional<Staff> recStaff=dao.findById(id);
		ResponseStructure<Staff> structure=new ResponseStructure<Staff>();
		if(recStaff.isPresent()) {
			structure.setBody(recStaff.get());
			structure.setMessage("Staff found ");
			structure.setCode(HttpStatus.FOUND.value());
		}
		else {
			structure.setBody(null);
			structure.setMessage("Staff Not Found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	public ResponseStructure<List<Staff>> findAllStaff() {
		ResponseStructure<List<Staff>> structure=new ResponseStructure<List<Staff>>();
		structure.setBody(dao.findAll());
		structure.setMessage("List of Staff ");
		structure.setCode(HttpStatus.FOUND.value());
		return structure;
	}
	
}
