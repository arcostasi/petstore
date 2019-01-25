package com.matera.cursoferias.petstore.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.matera.cursoferias.petstore.entity.Cliente;
import com.matera.cursoferias.petstore.repository.ClienteRepository;

@Component
public class ClienteBusiness implements ClienteBusinessInterface {

	private ClienteRepository clienteRepository;
	
	public ClienteBusiness(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
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
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		clienteRepository.deleteById(id);
	}

}
