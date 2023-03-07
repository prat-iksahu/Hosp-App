package org.jsp.HospitalApp.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Entity
@Data
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name,email;
	private long phone;
//	private List<EnCounter> counters;
	@OneToOne
	private Address address;
	@ManyToOne
	private Hospital hospital;
//	private List<Staff> staffs;
//	private List<Admin> admins;
	
}
