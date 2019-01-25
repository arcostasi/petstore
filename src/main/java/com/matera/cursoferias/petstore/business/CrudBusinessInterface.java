package com.matera.cursoferias.petstore.business;

import java.util.List;

import com.matera.cursoferias.petstore.entity.BaseEntity;

public interface CrudBusinessInterface<Entity, Id> {

	Entity save(Entity entity);
	
	List<Entity> findAll();

	Entity findById(Id id);
	
	void deleteById(Id id);

}
