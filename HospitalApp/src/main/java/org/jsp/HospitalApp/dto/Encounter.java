package org.jsp.HospitalApp.dto;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String reason,date;
	@OneToMany
	private List<MedOrder> medOrders;
	@ManyToOne
	private Branch branch;
	@ManyToOne
	private Person person;
	
	
	
	
	

}
