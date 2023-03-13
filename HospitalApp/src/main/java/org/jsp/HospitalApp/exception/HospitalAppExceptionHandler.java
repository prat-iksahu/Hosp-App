package org.jsp.HospitalApp.exception;

import org.jsp.HospitalApp.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HospitalAppExceptionHandler {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFound(IdNotFoundException e) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setBody(e.getMessage());
		structure.setMessage("user not found");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
