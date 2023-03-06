package org.jsp.HospitalApp.dto;

import java.util.List;

import lombok.Data;
@Data
public class EnCounter {
	private int id;
	private String reason,date;
	private List<MedOrder> medOrders;
	private Branch branch;
	
	
	

}
