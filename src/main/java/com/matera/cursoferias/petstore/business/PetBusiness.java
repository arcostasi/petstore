package com.matera.cursoferias.petstore.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.matera.cursoferias.petstore.entity.Pet;
import com.matera.cursoferias.petstore.entity.Servico;
import com.matera.cursoferias.petstore.exception.ResourceBadRequestException;
import com.matera.cursoferias.petstore.exception.ResourceNotFoundException;
import com.matera.cursoferias.petstore.repository.PetRepository;

@Component
public class PetBusiness implements PetBusinessInterface {

	private PetRepository petRepository;
	private ServicoBusiness servicoBusiness;
	
	public PetBusiness(PetRepository petRepository, ServicoBusiness servicoBusiness) {
		this.petRepository = petRepository;
		this.servicoBusiness = servicoBusiness;
	}

	@Override
	public Pet save(Pet entity) {
		return petRepository.save(entity);
	}

	@Override
	public List<Pet> findAll() {
		List<Pet> pets = new ArrayList<>();
		
		petRepository.findAll().forEach(pet -> pets.add(pet));
		
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		Pet pet = petRepository.findById(id).orElse(null);
		
		if (pet == null) {
			throw new ResourceNotFoundException(String.format("Pet %d não encontrado!", id));
		}
		
		return pet; 
	}

	@Override
	public void deleteById(Long id) {
		findById(id);
		
		List<Servico> servicos = servicoBusiness.findByPet_Id(id);
		
		if (!servicos.isEmpty()) {
			throw new ResourceBadRequestException(String.format("Pet %d não pode ser excluído pois possui Serviços!", id));
		}
			
		petRepository.deleteById(id);
	}

	@Override
	public List<Pet> findByEspecie_Id(Long idEspecie) {
		return petRepository.findByEspecie_Id(idEspecie);
	}

	@Override
	public List<Pet> findByCliente_Id(Long idCliente) {
		return petRepository.findByCliente_Id(idCliente);
	}
}
