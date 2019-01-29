package com.matera.cursoferias.petstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.matera.cursoferias.petstore.business.EspecieBusiness;
import com.matera.cursoferias.petstore.dto.EspecieRequestDTO;
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
	public Especie findEntityById(Long id) {
		return especieBusiness.findById(id);
	}

	@Override
	public EspecieResponseDTO convertEntityToResponseDTO(Especie entity) {
		EspecieResponseDTO especieResponseDTO = new EspecieResponseDTO();
		
		especieResponseDTO.setId(entity.getId());
		especieResponseDTO.setDescricao(entity.getDescricao());
		
		return especieResponseDTO;
	}

	@Override
	public EspecieResponseDTO save(Long id, EspecieRequestDTO requestDTO) {
		Especie especie = convertRequestDTOToEntity(id, requestDTO);
		
		especie = especieBusiness.save(especie);
		
		return convertEntityToResponseDTO(especie);
	}

	@Override
	public void deleteById(Long id) {
		especieBusiness.deleteById(id);
	}

	@Override
	public Especie convertRequestDTOToEntity(Long id, EspecieRequestDTO requestDTO) {
		Especie especie = id == null ? new Especie() : especieBusiness.findById(id);
		
		especie.setDescricao(requestDTO.getDescricao());
		
		return especie;
	}

}
