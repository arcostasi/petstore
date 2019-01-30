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

import com.matera.cursoferias.petstore.dto.ClienteRequestDTO;
import com.matera.cursoferias.petstore.dto.ClienteResponseDTO;
import com.matera.cursoferias.petstore.dto.PetResponseDTO;
import com.matera.cursoferias.petstore.service.ClienteService;
import com.matera.cursoferias.petstore.service.PetService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController extends BaseController {

	private ClienteService clienteService;
	private PetService petService;

	public ClienteController(ClienteService clienteService, PetService petService) {
		this.clienteService = clienteService;
		this.petService = petService;
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody ClienteRequestDTO ClienteRequestDTO) {
		ClienteResponseDTO ClienteResponseDTO = clienteService.save(null, ClienteRequestDTO);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
											 .path("/{id}")
											 .buildAndExpand(ClienteResponseDTO.getId())
											 .toUri();
		
		return ResponseEntity.created(uri)
				             .build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") Long id, @Valid @RequestBody ClienteRequestDTO ClienteRequestDTO) {
		clienteService.save(id, ClienteRequestDTO);

		return ResponseEntity.noContent()
				            .build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		clienteService.deleteById(id);
		
		return ResponseEntity.noContent()
	            	         .build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClienteResponseDTO> findById(@PathVariable("id") Long id) {
		ClienteResponseDTO clienteResponseDTO = clienteService.findById(id);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(clienteResponseDTO);
	}
	
	@RequestMapping(value = "/{id}/pets", method = RequestMethod.GET)
	public ResponseEntity<List<PetResponseDTO>> findPets(@PathVariable("id") Long id) {
		List<PetResponseDTO> pets = petService.findByCliente_Id(id);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(pets);
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteResponseDTO>> findAll() {
		List<ClienteResponseDTO> clientesResponseDTO = clienteService.findAll();
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(clientesResponseDTO);
	}
}
