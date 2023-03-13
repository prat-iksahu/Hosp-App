package org.jsp.HospitalApp.exception;

public class IdNotFoundException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Id Not Found or Invalid...";
	}
}
