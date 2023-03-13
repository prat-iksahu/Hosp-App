package org.jsp.HospitalApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dto.Staff;
import org.jsp.HospitalApp.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD
=======

>>>>>>> 38e9d8de89eac2640842242cb8deb5d806393cf4
@Repository
public class StaffDao {
	@Autowired
	StaffRepository repository;

	public Staff saveStaff(Staff staff) {
		return repository.save(staff);

	}

	public Staff updateStaff(Staff staff) {
		return repository.save(staff);

	}

	public void deleteById(int id) {
		repository.deleteById(id);
	}

	public Optional<Staff> findById(int id) {
		return repository.findById(id);

	}

	public List<Staff> findAll() {
		return repository.findAll();

	}

}
