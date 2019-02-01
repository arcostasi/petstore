package com.matera.cursoferias.petstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.matera.cursoferias.petstore.business.PetBusiness;
import com.matera.cursoferias.petstore.dto.PetRequestDTO;
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
		
		return convertListEntityToListResponseDTO(pets);
	}

	@Override
	public PetResponseDTO findById(Long id) {
		Pet pet = petBusiness.findById(id);
		
		return convertEntityToResponseDTO(pet);
	}
	
	@Override
	public Pet findEntityById(Long id) {
		return petBusiness.findById(id);
	}

	@Override
	public PetResponseDTO save(Long id, PetRequestDTO requestDTO) {
		Pet pet = convertRequestDTOToEntity(id, requestDTO);
		
		pet = petBusiness.save(pet);
		
		return convertEntityToResponseDTO(pet);
	}

	@Override
	public void deleteById(Long id) {
		petBusiness.deleteById(id);
	}

	@Override
	public List<PetResponseDTO> findByEspecie_Id(Long idEspecie) {
		List<Pet> especies = petBusiness.findByEspecie_Id(idEspecie);
		
		return convertListEntityToListResponseDTO(especies);
	}
	
	@Override
	public List<PetResponseDTO> findByCliente_Id(Long idCliente) {
		List<Pet> clientes = petBusiness.findByCliente_Id(idCliente);
		
		return convertListEntityToListResponseDTO(clientes);
	}
	
	@Override
	public Pet convertRequestDTOToEntity(Long id, PetRequestDTO requestDTO) {
		Pet pet = id == null ? new Pet() : petBusiness.findById(id);
		
		pet.setCliente(clienteService.findEntityById(requestDTO.getIdCliente()));
		pet.setDataNascimento(requestDTO.getDataNascimento());
		pet.setEspecie(especieService.findEntityById(requestDTO.getIdEspecie()));
		pet.setNome(requestDTO.getNome());
		
		return pet;
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

	private List<PetResponseDTO> convertListEntityToListResponseDTO(List<Pet> pets) {
		List<PetResponseDTO> result = new ArrayList<>();
		
		pets.forEach(pet -> result.add(convertEntityToResponseDTO(pet)));
		
		return result;
	}
	
}
