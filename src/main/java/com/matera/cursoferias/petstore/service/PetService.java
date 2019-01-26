package com.matera.cursoferias.petstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.matera.cursoferias.petstore.business.PetBusiness;
import com.matera.cursoferias.petstore.dto.PetResponseDTO;
import com.matera.cursoferias.petstore.entity.Pet;

@Service
public class PetService implements PetServiceInterface {

	private PetBusiness petBusiness;
	private ClienteService clienteService;
	private EspecieService especieService;
	
	public PetService(PetBusiness petBusiness, ClienteService clienteService, EspecieService especieService) {
		this.petBusiness = petBusiness;
		this.clienteService = clienteService;
		this.especieService = especieService;
	}

	@Override
	public List<PetResponseDTO> findAll() {
		List<Pet> pets = petBusiness.findAll();
		List<PetResponseDTO> result = new ArrayList<>();
		
		pets.forEach(pet -> result.add(convertEntityToResponseDTO(pet)));
		
		return result;
	}

	@Override
	public PetResponseDTO findById(Long id) {
		Pet pet = petBusiness.findById(id);
		
		return convertEntityToResponseDTO(pet);
	}

	@Override
	public PetResponseDTO convertEntityToResponseDTO(Pet entity) {
		PetResponseDTO petResponseDTO = new PetResponseDTO();
		
		petResponseDTO.setId(entity.getId());
		petResponseDTO.setNome(entity.getNome());
		petResponseDTO.setDataNascimento(entity.getDataNascimento());
		petResponseDTO.setEspecie(especieService.convertEntityToResponseDTO(entity.getEspecie()));
		petResponseDTO.setCliente(clienteService.convertEntityToResponseDTO(entity.getCliente()));
		
		return petResponseDTO;
	}

}
