package com.matera.cursoferias.petstore.service;

import java.util.List;

import com.matera.cursoferias.petstore.entity.BaseEntity;

public interface CrudServiceInterface<RequestDTO, ResponseDTO, Entity extends BaseEntity, Id> {

	ResponseDTO save(Id id, RequestDTO requestDTO);
	
	List<ResponseDTO> findAll();
	
	ResponseDTO findById(Id id);
	
	Entity findEntityById(Id id);
	
	void deleteById(Id id);
	
	Entity convertRequestDTOToEntity(Id id, RequestDTO requestDTO);
	
	ResponseDTO convertEntityToResponseDTO(Entity entity);

}
