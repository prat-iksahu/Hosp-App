package org.jsp.HospitalApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dto.MedOrder;
import org.jsp.HospitalApp.repository.MedOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MedOrderDao {
	@Autowired
	MedOrderRepository repository;

	public MedOrder saveMedOrder(MedOrder medOrder) {
		return repository.save(medOrder);
	}

	public MedOrder updateMedOrder(MedOrder medOrder) {
		return repository.save(medOrder);
	}

	public Optional<MedOrder> findById(int id) {
		return repository.findById(id);
	}

	public void deleteById(int id) {
		repository.deleteById(id);

	}

	public List<MedOrder> findAll() {
		return repository.findAll();
	}

}
