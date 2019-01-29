package com.matera.cursoferias.petstore.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matera.cursoferias.petstore.dto.EspecieRequestDTO;
import com.matera.cursoferias.petstore.dto.EspecieResponseDTO;
import com.matera.cursoferias.petstore.dto.PetResponseDTO;
import com.matera.cursoferias.petstore.service.EspecieService;
import com.matera.cursoferias.petstore.service.PetService;

@RestController
@RequestMapping("/api/v1/especies")
public class EspecieController {

	private EspecieService especieService;
	private PetService petService;

	public EspecieController(EspecieService especieService, PetService petService) {
		this.especieService = especieService;
		this.petService = petService;
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody EspecieRequestDTO especieRequestDTO) {
		EspecieResponseDTO especieResponseDTO = especieService.save(null, especieRequestDTO);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
											 .path("/{id}")
											 .buildAndExpand(especieResponseDTO.getId())
											 .toUri();
		
		return ResponseEntity.created(uri)
				             .build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody EspecieRequestDTO especieRequestDTO) {
		especieService.save(id, especieRequestDTO);

		return ResponseEntity.noContent()
				            .build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		especieService.deleteById(id);
		
		return ResponseEntity.noContent()
	            	         .build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/{id}/pets", method = RequestMethod.GET) 
	public ResponseEntity<List<PetResponseDTO>> findPets(@PathVariable("id") Long id){
		List<PetResponseDTO> pets = petService.findByEspecie_Id(id);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(pets);
	}
	
}
