package com.matera.cursoferias.petstore.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.matera.cursoferias.petstore.entity.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

	List<Pet> findByEspecie_Id(Long id);
	
	List<Pet> findByCliente_Id(Long id);
	
	List<Pet> findByIdAndDataNascimento(Long id, LocalDate dataNascimento);
		
	@Query("SELECT p FROM Pet p WHERE p.id = ?1")
	List<Pet> findByEspecie_IdComJPQL(@Param("id") Long id);
	
	@Query(value = "SELECT p.* FROM Pet p INNER JOIN Especie e ON e.id = p.id_especie WHERE e.id = :id", 
			nativeQuery = true)
	List<Pet> findByEspecie_IdComSQLNativo(@Param("id") Long id);
	
}
