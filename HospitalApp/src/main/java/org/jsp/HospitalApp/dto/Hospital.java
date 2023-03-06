package org.jsp.HospitalApp.dto;
<<<<<<< HEAD


=======
>>>>>>> 51421952415f373939d7259e9c3305c247a60a6f
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name,founder;
	private int yoe;
	private String gstno;
	private List<Branch> branches;
	
}
