package com.matera.cursoferias.petstore.service;

import java.util.List;

import com.matera.cursoferias.petstore.entity.BaseEntity;

public interface CrudServiceInterface<ResponseDTO, Entity extends BaseEntity, Id> {

	List<ResponseDTO> findAll();
	
	ResponseDTO findById(Id id);
	
	ResponseDTO convertEntityToResponseDTO(Entity entity);

}
