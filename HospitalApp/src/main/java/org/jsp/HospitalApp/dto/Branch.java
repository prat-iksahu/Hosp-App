package org.jsp.HospitalApp.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name,email;
	private long phone;
	private List<EnCounter> counters;
	private Address address;
	private Hospital hospital;
	private List<Staff> staffs;
	private List<Admin> admins;
	
}
