package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.BranchDao;
import org.jsp.HospitalApp.dto.Branch;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
	@Autowired
	private BranchDao branchDao;

	public ResponseStructure<Branch> saveBranch(Branch branch) {
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();

		structure.setBody(branchDao.saveBranch(branch));
		structure.setMessage("Saved Successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());

		return structure;
	}

	public ResponseStructure<Branch> updateBranch(Branch branch) {
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();

		structure.setBody(branchDao.updateBranch(branch));
		structure.setMessage("Saved Successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());

		return structure;
	}

	public ResponseStructure<String> deleteBranch(int id) {
		ResponseStructure<String> structure = new ResponseStructure<String>();

		Optional<Branch> op = branchDao.getBranchById(id);
		if (op.isPresent()) {
			branchDao.deleteBranch(id);

			structure.setBody("User Present");
			structure.setMessage("Deleted Successfully");
			structure.setCode(HttpStatus.FOUND.value());
		} else {
			structure.setBody("User Not Present");
			structure.setMessage("Cannot Delete");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}

		return structure;
	}

	public ResponseStructure<Branch> getBranch(int id) {
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();

		Optional<Branch> op = branchDao.getBranchById(id);
		if (op.isPresent()) {
			structure.setBody(op.get());
			structure.setMessage("Id is present");
			structure.setCode(HttpStatus.FOUND.value());
		} else {
			structure.setBody(null);
			structure.setMessage("Id not Present");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}

		return structure;
	}

	public ResponseStructure<List<Branch>> getAll() {
		ResponseStructure<List<Branch>> structure = new ResponseStructure<List<Branch>>();
		structure.setBody(branchDao.getAll());
		structure.setMessage("Records are fetched");
		structure.setCode(HttpStatus.FOUND.value());
		return structure;
	}
}
