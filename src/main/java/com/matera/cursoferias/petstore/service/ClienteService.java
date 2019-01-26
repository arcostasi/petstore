package com.matera.cursoferias.petstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.matera.cursoferias.petstore.business.ClienteBusiness;
import com.matera.cursoferias.petstore.dto.ClienteResponseDTO;
import com.matera.cursoferias.petstore.entity.Cliente;

@Service
public class ClienteService implements ClienteServiceInterface {

	private ClienteBusiness clienteBusiness;

	public ClienteService(ClienteBusiness clienteBusiness) {
		this.clienteBusiness = clienteBusiness;
	}

	@Override
	public List<ClienteResponseDTO> findAll() {
		List<Cliente> clientes = clienteBusiness.findAll();
		List<ClienteResponseDTO> result = new ArrayList<>();
		
		clientes.forEach(cliente -> result.add(convertEntityToResponseDTO(cliente)));
		
		return result;
	}

	@Override
	public ClienteResponseDTO findById(Long id) {
		Cliente cliente = clienteBusiness.findById(id);
		
		return convertEntityToResponseDTO(cliente);
	}

	@Override
	public ClienteResponseDTO convertEntityToResponseDTO(Cliente entity) {
		ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
		
		clienteResponseDTO.setId(entity.getId());
		clienteResponseDTO.setNome(entity.getNome());
		
		return clienteResponseDTO;
	}
	
}
