package com.matera.cursoferias.petstore.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.matera.cursoferias.petstore.entity.Especie;
import com.matera.cursoferias.petstore.repository.EspecieRepository;

@Component
public class EspecieBusiness implements EspecieBusinessInterface {

	private EspecieRepository especieRepository;
	
	public EspecieBusiness(EspecieRepository especieRepository) {
		this.especieRepository = especieRepository;
	}

	@Override
	public Especie save(Especie entity) {
		return especieRepository.save(entity);
	}

	@Override
	public List<Especie> findAll() {
		List<Especie> especies = new ArrayList<>();
		
		especieRepository.findAll().forEach(especie -> especies.add(especie));
		
		return especies;
	}

	@Override
	public Especie findById(Long id) {
		return especieRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		especieRepository.deleteById(id);
	}

}
