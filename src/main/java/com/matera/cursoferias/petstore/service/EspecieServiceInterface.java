package com.matera.cursoferias.petstore.service;

import com.matera.cursoferias.petstore.dto.EspecieRequestDTO;
import com.matera.cursoferias.petstore.dto.EspecieResponseDTO;
import com.matera.cursoferias.petstore.entity.Especie;

public interface EspecieServiceInterface extends CrudServiceInterface<EspecieRequestDTO, EspecieResponseDTO, Especie,  Long> {

}
