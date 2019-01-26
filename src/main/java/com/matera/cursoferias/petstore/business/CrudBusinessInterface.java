package com.matera.cursoferias.petstore.business;

import java.util.List;

public interface CrudBusinessInterface<Entity, Id> {

	Entity save(Entity entity);
	
	List<Entity> findAll();

	Entity findById(Id id);
	
	void deleteById(Id id);

}
