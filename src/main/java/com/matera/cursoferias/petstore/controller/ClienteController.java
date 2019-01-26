package com.matera.cursoferias.petstore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matera.cursoferias.petstore.dto.ClienteResponseDTO;
import com.matera.cursoferias.petstore.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

	private ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<ClienteResponseDTO> findById(@PathVariable("id") Long id) {
		ClienteResponseDTO clienteResponseDTO = clienteService.findById(id);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(clienteResponseDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteResponseDTO>> findAll() {
		List<ClienteResponseDTO> clientesResponseDTO = clienteService.findAll();
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(clientesResponseDTO);
	}
}
