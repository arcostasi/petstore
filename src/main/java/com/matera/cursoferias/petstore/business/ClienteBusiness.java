package com.matera.cursoferias.petstore.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.matera.cursoferias.petstore.entity.Cliente;
import com.matera.cursoferias.petstore.entity.Pet;
import com.matera.cursoferias.petstore.exception.ResourceBadRequestException;
import com.matera.cursoferias.petstore.exception.ResourceNotFoundException;
import com.matera.cursoferias.petstore.repository.ClienteRepository;

@Component
public class ClienteBusiness implements ClienteBusinessInterface {

	private ClienteRepository clienteRepository;
	private PetBusiness petBusiness;
	
	public ClienteBusiness(ClienteRepository clienteRepository, PetBusiness petBusiness) {
		this.clienteRepository = clienteRepository;
		this.petBusiness = petBusiness;
	}

	@Override
	public Cliente save(Cliente entity) {
		return clienteRepository.save(entity);
	}

	@Override
	public List<Cliente> findAll() {
		List<Cliente> clientes = new ArrayList<>();
		
		clienteRepository.findAll().forEach(cliente -> clientes.add(cliente));
		
		return clientes;
	}

	@Override
	public Cliente findById(Long id) {
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		
		if (cliente == null) {
			throw new ResourceNotFoundException(String.format("Cliente %d não encontrado!", id));
		}
		
		return cliente;
	}

	@Override
	public void deleteById(Long id) {
		findById(id);
		
		List<Pet> pets = petBusiness.findByCliente_Id(id);
		
		if (!pets.isEmpty()) {
			throw new ResourceBadRequestException(String.format("Cliente %d não pode ser excluído pois possui Pets!", id, pets.size())); 
		}
		
		clienteRepository.deleteById(id);
	}

}
