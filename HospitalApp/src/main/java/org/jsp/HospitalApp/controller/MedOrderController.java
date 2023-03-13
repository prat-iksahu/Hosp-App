package org.jsp.HospitalApp.controller;

import java.util.List;

import org.jsp.HospitalApp.dto.MedOrder;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.jsp.HospitalApp.service.MedOrderService;
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
public class MedOrderController {
	@Autowired
	MedOrderService service;

	@PostMapping("/medOrder")
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestBody MedOrder medOrder) {
		return service.saveMedOrder(medOrder);
	}

	@PutMapping("/medOrder")
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestBody MedOrder medOrder) {
		return service.updateMedOrder(medOrder);
	}

	@DeleteMapping("/medOrder/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(@PathVariable int id) {

		return service.deleteMedOrder(id);
	}

	@GetMapping("/medOrder/{id}")
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrder(@PathVariable int id) {
		return service.findMedOrderById(id);
	}

	@GetMapping("/medOrder/all")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAll() {
		return service.findAllMedOrder() ;

	}

}
