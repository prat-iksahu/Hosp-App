package org.jsp.HospitalApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.HospitalApp.dao.EncounterDao;
import org.jsp.HospitalApp.dto.Encounter;
import org.jsp.HospitalApp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service

public class EncounterService 
{
	@Autowired
	EncounterDao dao;

	public ResponseStructure<Encounter> saveEncounter(Encounter encounter) {
		ResponseStructure<Encounter> structure=new ResponseStructure<Encounter>();
		structure.setBody(dao.saveEncounter(encounter));
		structure.setMessage("Encounter saved successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}

	public ResponseStructure<Encounter> updateEncounter(Encounter encounter) {
		ResponseStructure<Encounter> structure=new ResponseStructure<Encounter>();
		structure.setBody(dao.updateEncounter(encounter));
		structure.setMessage("Encounter Updated successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}

	
	public ResponseStructure<String> deleteEnconter(int id) {
		Optional<Encounter> recEncounter=dao.findById(id);
		ResponseStructure<String> structure=new ResponseStructure<String>();
		if(recEncounter.isPresent()) {
			dao.deleteById(id);
			structure.setBody("Encounter found");
			structure.setMessage("Encounter found and deleted successfully");
			structure.setCode(HttpStatus.FOUND.value());
		}
		else {
			structure.setBody("Encounter Not found");
			structure.setMessage("Unable to delete the Encounter");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		
		return structure;
	}

	public ResponseStructure<Encounter> findEncounter(int id) {
		Optional<Encounter> recEncounter=dao.findById(id);
		ResponseStructure<Encounter> structure=new ResponseStructure<Encounter>();
		if(recEncounter.isPresent()) {
			structure.setBody(recEncounter.get());
			structure.setMessage("Encounter found ");
			structure.setCode(HttpStatus.FOUND.value());
		}
		else {
			structure.setBody(null);
			structure.setMessage("Encounter Not Found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	public ResponseStructure<List<Encounter>> findAll() {
		ResponseStructure<List<Encounter>> structure=new ResponseStructure<List<Encounter>>();
		structure.setBody(dao.findAll());
		structure.setMessage("List of Encounter ");
		structure.setCode(HttpStatus.FOUND.value());
		return structure;
	}
}