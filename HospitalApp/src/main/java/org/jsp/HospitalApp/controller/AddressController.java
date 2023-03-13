package org.jsp.HospitalApp.controller;

import java.util.List;

import org.jsp.HospitalApp.dto.Address;
import org.jsp.HospitalApp.dto.Admin;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
	@Autowired
	private AddressService service;

	@PostMapping("/address")
	public ResponseStructure<Address> saveAddress(@RequestBody Address address) {
		return service.saveAddress(address);
	}

	@PutMapping("/address")
	public ResponseStructure<Address> updateAddress(@RequestBody Address address) {
		return service.updateAddress(address);
	}

	@DeleteMapping("/address/{id}")
	public ResponseStructure<String> deleteAddress(@PathVariable int id) {
		return service.deleteAddress(id);
	}

	@GetMapping("/address/{id}")
	public ResponseStructure<Address> findAddressById(@PathVariable int id) {
		return service.findAddressById(id);
	}

	@GetMapping("/address/all")
	public ResponseStructure<List<Address>>findAllAddress () {
		return service.findAllAddress();
	}
}

