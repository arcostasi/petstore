package com.matera.cursoferias.petstore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matera.cursoferias.petstore.dto.EspecieResponseDTO;
import com.matera.cursoferias.petstore.service.EspecieService;

@RestController
@RequestMapping("/api/v1/especies")
public class EspecieController {

	private EspecieService especieService;

	public EspecieController(EspecieService especieService) {
		this.especieService = especieService;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<EspecieResponseDTO> findById(@PathVariable("id") Long id) {
		EspecieResponseDTO especieResponseDTO = especieService.findById(id);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(especieResponseDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<EspecieResponseDTO>> findAll() {
		List<EspecieResponseDTO> especiesResponseDTO = especieService.findAll();
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(especiesResponseDTO);
	}
	
}
