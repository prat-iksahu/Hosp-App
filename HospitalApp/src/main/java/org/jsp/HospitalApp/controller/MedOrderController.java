package org.jsp.HospitalApp.controller;

import java.util.List;

import org.jsp.HospitalApp.dto.MedOrder;
import org.jsp.HospitalApp.repository.MedOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MedOrderController {
	@Autowired
	private MedOrderRepository medOrderRepository;

	@PostMapping("/medOrder")
	public MedOrder saveMedOrder(@RequestBody MedOrder medOrder ) {
		
		return medOrderRepository.save(medOrder);
	}

	@PutMapping("/medOrder")
	public MedOrder updateMedOrder(@RequestBody MedOrder medOrder ) {
		return medOrderRepository.save(medOrder);
	}

	@DeleteMapping("/medOrder/{id}")
	public void deleteMedOrder(@PathVariable int id) {
		medOrderRepository.deleteById(id);
	}

	@GetMapping("/medOrder/{id}")
	public MedOrder getMedOrder(@PathVariable int id) {
		return medOrderRepository.findById(id).get();
	}

	@GetMapping("/medOrder/all")
	public List<MedOrder> getAll() {
		return medOrderRepository.findAll();
	}


}
