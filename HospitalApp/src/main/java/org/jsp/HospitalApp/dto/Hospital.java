package org.jsp.HospitalApp.dto;

<<<<<<< HEAD
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
	
=======
import javax.persistence.Entity;

@Entity
public class Hospital {
	private int id;
	private String name;
	private String founder;
	private int yoe;
	private int gst;
>>>>>>> 00dc1c217c5485a69d08ebfbc46dca48984efaa6
}
