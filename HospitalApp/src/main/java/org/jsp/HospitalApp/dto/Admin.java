package org.jsp.HospitalApp.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
	private String name,email,password;
	private long phone;
	private Branch branch;
		
	}


