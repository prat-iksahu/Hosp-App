package org.jsp.HospitalApp.dto;

import javax.persistence.Entity;

@Entity
public class Hospital {
	private int id;
	private String name;
	private String founder;
	private int yoe;
	private int gst;
}
