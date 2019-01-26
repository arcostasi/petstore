package com.matera.cursoferias.petstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.matera.cursoferias.petstore.business.EspecieBusiness;
import com.matera.cursoferias.petstore.dto.EspecieResponseDTO;
import com.matera.cursoferias.petstore.entity.Especie;

@Service
public class EspecieService implements EspecieServiceInterface {

	private EspecieBusiness especieBusiness;
	
	public EspecieService(EspecieBusiness especieBusiness) {
		this.especieBusiness = especieBusiness;
	}

	@Override
	public List<EspecieResponseDTO> findAll() {
		List<Especie> especies = especieBusiness.findAll();
		List<EspecieResponseDTO> result = new ArrayList<>();
		
		especies.forEach(especie -> result.add(convertEntityToResponseDTO(especie)));
		
		return result;
	}

	@Override
	public EspecieResponseDTO findById(Long id) {
		Especie especie = especieBusiness.findById(id);
				
		return convertEntityToResponseDTO(especie);
	}

	@Override
	public EspecieResponseDTO convertEntityToResponseDTO(Especie entity) {
		EspecieResponseDTO especieResponseDTO = new EspecieResponseDTO();
		
		especieResponseDTO.setId(entity.getId());
		especieResponseDTO.setDescricao(entity.getDescricao());
		
		return especieResponseDTO;
	}

}
