package com.matera.cursoferias.petstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.matera.cursoferias.petstore.dto.ExceptionResponseDTO;
import com.matera.cursoferias.petstore.exception.ResourceBadRequestException;
import com.matera.cursoferias.petstore.exception.ResourceNotFoundException;

public class BaseController {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({Exception.class})
	public ExceptionResponseDTO handlerException(Exception e) {
		return ExceptionResponseDTO.withError("Erro inesperado ao executar a operação: " + e.getMessage());
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ResourceNotFoundException.class})
	public ExceptionResponseDTO handlerResourceNotFoundException(ResourceNotFoundException e) {
		return ExceptionResponseDTO.withError(e.getMessage());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ResourceBadRequestException.class})
	public ExceptionResponseDTO handlerResourceBadRequestException(ResourceBadRequestException e) {
		return ExceptionResponseDTO.withError(e.getMessage());
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ExceptionResponseDTO handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		return ExceptionResponseDTO.withError(e.getBindingResult().getFieldErrors());
	}	
}
