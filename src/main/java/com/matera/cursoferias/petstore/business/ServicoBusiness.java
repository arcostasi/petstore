package com.matera.cursoferias.petstore.business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.matera.cursoferias.petstore.entity.Servico;
import com.matera.cursoferias.petstore.repository.ServicoRepository;

@Component
public class ServicoBusiness implements ServicoBusinessInterface {

	private ServicoRepository servicoRepository;
	
	public ServicoBusiness(ServicoRepository servicoRepository) {
		this.servicoRepository = servicoRepository;
	}

	@Override
	public Servico save(Servico entity) {
		return servicoRepository.save(entity);
	}

	@Override
	public List<Servico> findAll() {
		List<Servico> servicos = new ArrayList<>();
		
		servicoRepository.findAll().forEach(servico -> servicos.add(servico));
		
		return servicos;
	}

	@Override
	public Servico findById(Long id) {
		return servicoRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		servicoRepository.deleteById(id);
	}

	@Override
	public List<Servico> findByPet_Id(Long id) {
		return servicoRepository.findByPet_Id(id);
	}

	@Override
	public List<Servico> findByDataHoraBetween(LocalDateTime dataInicial, LocalDateTime dataFinal) {
		return servicoRepository.findByDataHoraBetween(dataInicial, dataFinal);
	}

}
