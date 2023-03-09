package org.jsp.HospitalApp.controller;

import java.util.List;

import org.jsp.HospitalApp.dto.Address;
import org.jsp.HospitalApp.repository.AddressRepository;
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
	private AddressRepository addressRepository;
	
	@PostMapping("/address")
	public Address saveAddress(@RequestBody Address address) {
		
		return addressRepository.save(address);
	}

	@PutMapping("/address")
	public Address updateAddress(@RequestBody Address address) {
		return addressRepository.save(address);
	}

	@DeleteMapping("/address/{id}")
	public void deleteAddress(@PathVariable int id) {
		addressRepository.deleteById(id);
	}

	@GetMapping("/address/{id}")
	public Address getAddress(@PathVariable int id) {
		return addressRepository.findById(id).get();
	}

	@GetMapping("/address/all")
	public List<Address> getAll() {
		return addressRepository.findAll();
	}
	

	

}
