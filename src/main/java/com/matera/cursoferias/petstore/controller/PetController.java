package com.matera.cursoferias.petstore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matera.cursoferias.petstore.dto.PetResponseDTO;
import com.matera.cursoferias.petstore.service.PetService;

@RestController
@RequestMapping("/api/v1/pets")
public class PetController {

	private PetService petService;

	public PetController(PetService petService) {
		this.petService = petService;
	}

	@RequestMapping(value = "/{id}",  method = RequestMethod.GET)
	public ResponseEntity<PetResponseDTO> findById(@PathVariable("id") Long id) {
		PetResponseDTO petResponseDTO = petService.findById(id);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(petResponseDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<PetResponseDTO>> findAll() {
		List<PetResponseDTO> petsResponseDTO = petService.findAll();
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(petsResponseDTO);
	}

}