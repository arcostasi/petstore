package com.matera.cursoferias.petstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.matera.cursoferias.petstore.business.ClienteBusiness;
import com.matera.cursoferias.petstore.dto.ClienteRequestDTO;
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
		
		return convertListEntityToListResponseDTO(clientes);
	}

	@Override
	public ClienteResponseDTO findById(Long id) {
		Cliente cliente = clienteBusiness.findById(id);
		
		return convertEntityToResponseDTO(cliente);
	}

	@Override
	public Cliente findEntityById(Long id) {
		return clienteBusiness.findById(id);
	}
	
	@Override
	public ClienteResponseDTO convertEntityToResponseDTO(Cliente entity) {
		ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
		
		clienteResponseDTO.setId(entity.getId());
		clienteResponseDTO.setNome(entity.getNome());
		
		return clienteResponseDTO;
	}

	@Override
	public ClienteResponseDTO save(Long id, ClienteRequestDTO requestDTO) {
		Cliente cliente = convertRequestDTOToEntity(id, requestDTO);
		
		cliente = clienteBusiness.save(cliente);
		
		return  convertEntityToResponseDTO(cliente);
	}

	@Override
	public void deleteById(Long id) {
		clienteBusiness.deleteById(id);
	}

	@Override
	public Cliente convertRequestDTOToEntity(Long id, ClienteRequestDTO requestDTO) {
		Cliente cliente = id == null ? new Cliente() : clienteBusiness.findById(id);
		
		cliente.setNome(requestDTO.getNome());
		
		return cliente;
	}

	private List<ClienteResponseDTO> convertListEntityToListResponseDTO(List<Cliente> clientes) {
		List<ClienteResponseDTO> result = new ArrayList<>();
		
		clientes.forEach(cliente -> result.add(convertEntityToResponseDTO(cliente)));
		
		return result;
	}

}
