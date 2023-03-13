package org.jsp.HospitalApp.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name, email;
	private long phone;
	@ManyToOne
	private Hospital hospital;
	@OneToOne
	private Address address;
	@OneToMany
	private List<Encounter> counters;
	@OneToMany
	private List<Admin> admin;
	@OneToMany
	private List<Staff> staffs;

}
