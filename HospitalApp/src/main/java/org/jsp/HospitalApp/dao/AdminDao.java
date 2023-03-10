package org.jsp.HospitalApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dto.Admin;
import org.jsp.HospitalApp.dto.Person;
import org.jsp.HospitalApp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
	@Autowired
	AdminRepository repository;

	public Admin saveAdmin(Admin admin) {
		return repository.save(admin);

	}

	public Admin updateAdmin(Admin admin) {
		return repository.save(admin);

	}

	public void deleteById(int id) {

		repository.deleteById(id);
	}

	public Optional<Admin> findById(int id) {
		return repository.findById(id);

	}

	public List<Admin> findAll() {
		return repository.findAll();

	}

}
