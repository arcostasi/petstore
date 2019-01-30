package com.matera.cursoferias.petstore.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

public class ExceptionResponseDTO {

	private List<String> errors;
	
	public static ExceptionResponseDTO buildException(List<String> listErrors) {
		ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO();
		exceptionResponseDTO.setErrors(listErrors);
		
		return exceptionResponseDTO;
	}
	
	public static ExceptionResponseDTO withError(String error) {
		List<String> listErrors = new ArrayList<>();
		listErrors.add(error);
		
		return buildException(listErrors);
	}

	public static ExceptionResponseDTO withError(List<FieldError> errors) {
		List<String> listErrors = new ArrayList<>();
		
		errors.forEach(error -> listErrors.add(String.format("%s: %s", error.getField(), error.getDefaultMessage())));

		return buildException(listErrors);
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
}
