package com.matera.cursoferias.petstore.business;

import java.util.List;

import com.matera.cursoferias.petstore.entity.Pet;

public interface PetBusinessInterface extends CrudBusinessInterface<Pet, Long> {

	List<Pet> findByEspecie_Id(Long id);
	
}
