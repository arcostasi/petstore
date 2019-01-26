package com.matera.cursoferias.petstore.service;

import com.matera.cursoferias.petstore.dto.PetResponseDTO;
import com.matera.cursoferias.petstore.entity.Pet;

public interface PetServiceInterface extends CrudServiceInterface<PetResponseDTO, Pet,  Long> {

}
