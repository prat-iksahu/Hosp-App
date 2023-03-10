package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.AddressDao;
import org.jsp.HospitalApp.dto.Address;
import org.jsp.HospitalApp.dto.Admin;
import org.jsp.HospitalApp.dto.Person;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
	@Autowired
	AddressDao dao;

	public ResponseStructure<Address> savePerson(Address address) {
		ResponseStructure<Address> structure = new ResponseStructure<Address>();
		structure.setBody(dao.saveAddress(address));
		structure.setMessage("Address saved successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}

	public ResponseStructure<Address> updatePerson(Address address) {
		ResponseStructure<Address> structure = new ResponseStructure<Address>();
		structure.setBody(dao.updateAddress(address));
		structure.setMessage("Address update successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		;
		return structure;
	}

	public ResponseStructure<String> deleteAddress(int id) {
		Optional<Address> recAddress = dao.findById(id);
		ResponseStructure<String> structure = new ResponseStructure<String>();
		if (recAddress.isPresent()) {
			dao.deleteById(id);
			structure.setBody("Address found");
			structure.setMessage("Address found and deleted successfully");
			structure.setCode(HttpStatus.FOUND.value());
		} else {
			structure.setBody("Address Not found");
			structure.setMessage("Unable to delete the Address");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}

		return structure;
	}

	public ResponseStructure<Address> findPersonById(int id) {
		Optional<Address> recAddress = dao.findById(id);
		ResponseStructure<Address> structure = new ResponseStructure<Address>();
		if (recAddress.isPresent()) {
			structure.setBody(recAddress.get());
			structure.setMessage("Address found ");
			structure.setCode(HttpStatus.FOUND.value());
		} else {
			structure.setBody(null);
			structure.setMessage("Address Not Found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	public ResponseStructure<List<Address>> findAllPerson() {
		ResponseStructure<List<Address>> structure = new ResponseStructure<List<Address>>();
		structure.setBody(dao.findAll());
		structure.setMessage("List of Address");
		structure.setCode(HttpStatus.FOUND.value());
		return structure;
	}
}
