package com.matera.cursoferias.petstore.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import com.matera.cursoferias.petstore.dto.PetRequestDTO;
import com.matera.cursoferias.petstore.dto.PetResponseDTO;
import com.matera.cursoferias.petstore.dto.ServicoResponseDTO;
import com.matera.cursoferias.petstore.service.PetService;
import com.matera.cursoferias.petstore.service.ServicoService;

@RestController
@RequestMapping("/api/v1/pets")
public class PetController extends BaseController {

	private PetService petService;
	private ServicoService servicoService;

	public PetController(PetService petService, ServicoService servicoService) {
		super();
		this.petService = petService;
		this.servicoService = servicoService;
	}

	@PostMapping()
	public ResponseEntity<Void> save(@Valid @RequestBody PetRequestDTO petRequestDTO) {
		PetResponseDTO petResponseDTO = petService.save(null, petRequestDTO);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
											 .path("/{id}")
											 .buildAndExpand(petResponseDTO.getId())
											 .toUri();
		
		return ResponseEntity.created(uri)
							 .build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") Long id, @Valid @RequestBody PetRequestDTO petRequestDTO) {
		petService.save(id, petRequestDTO);
		
		return ResponseEntity.noContent()
							 .build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
		petService.deleteById(id);
		
		return ResponseEntity.noContent()
							 .build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PetResponseDTO> findById(@PathVariable("id") Long id) {
		PetResponseDTO petResponseDTO = petService.findById(id);
		
		return ResponseEntity.status(HttpStatus.OK)
							 .body(petResponseDTO);
	}

	@RequestMapping(value = "/{id}/servicos", method = RequestMethod.GET)
	public ResponseEntity<List<ServicoResponseDTO>> findServicos(@PathVariable("id") Long id) {
		List<ServicoResponseDTO> servicos = servicoService.findByPet_Id(id);
		
		return ResponseEntity.status(HttpStatus.OK)
							 .body(servicos);
	}

	@GetMapping()
	public ResponseEntity<List<PetResponseDTO>> findAll() {
		List<PetResponseDTO> petsResponseDTO = petService.findAll();
		
		return ResponseEntity.status(HttpStatus.OK)
							 .body(petsResponseDTO);
	}

}