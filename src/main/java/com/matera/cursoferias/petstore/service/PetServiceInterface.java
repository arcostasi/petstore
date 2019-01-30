package com.matera.cursoferias.petstore.service;

import java.util.List;

import com.matera.cursoferias.petstore.dto.PetRequestDTO;
import com.matera.cursoferias.petstore.dto.PetResponseDTO;
import com.matera.cursoferias.petstore.entity.Pet;

public interface PetServiceInterface extends CrudServiceInterface<PetRequestDTO, PetResponseDTO, Pet,  Long> {
	
	List<PetResponseDTO> findByEspecie_Id(Long idEspecie);
	
	List<PetResponseDTO> findByCliente_Id(Long idCliente);
	
}
