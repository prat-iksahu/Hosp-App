package org.jsp.HospitalApp.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name,designation,email,password;
	private long phone;
	private int branch_id;
	private Branch branch;
	

}
