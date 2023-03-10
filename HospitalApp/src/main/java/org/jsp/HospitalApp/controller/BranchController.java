package org.jsp.HospitalApp.controller;
import java.util.List;
import org.jsp.HospitalApp.dto.Branch;
import org.jsp.HospitalApp.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BranchController {
	@Autowired
	private BranchRepository branchRepository;

	@PostMapping("/branch")
	public Branch saveBranch(@RequestBody Branch branch) {
		
		return branchRepository.save(branch);
	}

	@PutMapping("/branch")
	public Branch updateBranch(@RequestBody Branch branch) {
		return branchRepository.save(branch);
	}

	@DeleteMapping("/branch/{id}")
	public void deleteBranch(@PathVariable int id) {
		branchRepository.deleteById(id);
	}

	@GetMapping("/branch/{id}")
	public Branch getBranch(@PathVariable int id) {
		Optional<Branch> optional=branchRepository.findById(id);
		return optional.get();
	}

	@GetMapping("/branch/all")
	public List<Branch> getAll() {
		return branchRepository.findAll();
	}

}
