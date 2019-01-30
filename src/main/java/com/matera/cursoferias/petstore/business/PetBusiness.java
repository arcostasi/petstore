package com.matera.cursoferias.petstore.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.matera.cursoferias.petstore.entity.Pet;
import com.matera.cursoferias.petstore.repository.PetRepository;

@Component
public class PetBusiness implements PetBusinessInterface {

	private PetRepository petRepository;
	
	public PetBusiness(PetRepository petRepository) {
		this.petRepository = petRepository;
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
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
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
