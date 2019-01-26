package com.matera.cursoferias.petstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.matera.cursoferias.petstore.business.ServicoBusiness;
import com.matera.cursoferias.petstore.dto.ServicoResponseDTO;
import com.matera.cursoferias.petstore.entity.Servico;

@Service
public class ServicoService implements ServicoServiceInterface {

	private ServicoBusiness servicoBusiness;
	private PetService petService;
	
	public ServicoService(ServicoBusiness servicoBusiness, PetService petService) {
		this.servicoBusiness = servicoBusiness;
		this.petService = petService;
	}

	@Override
	public List<ServicoResponseDTO> findAll() {
		List<Servico> servicos = servicoBusiness.findAll();
		List<ServicoResponseDTO> result = new ArrayList<>();
		
		servicos.forEach(servico -> result.add(convertEntityToResponseDTO(servico)));
		
		return result;
	}

	@Override
	public ServicoResponseDTO findById(Long id) {
		Servico servico = servicoBusiness.findById(id);
		
		return convertEntityToResponseDTO(servico);
	}

	@Override
	public ServicoResponseDTO convertEntityToResponseDTO(Servico entity) {
		ServicoResponseDTO servicoResponseDTO = new ServicoResponseDTO();
		
		servicoResponseDTO.setId(entity.getId());
		servicoResponseDTO.setDataHora(entity.getDataHora());
		servicoResponseDTO.setObservacao(entity.getObservacao());
		servicoResponseDTO.setPet(petService.convertEntityToResponseDTO(entity.getPet()));
		servicoResponseDTO.setTipoServico(entity.getTipoServico().getDescricao());
		servicoResponseDTO.setValor(entity.getValor());
		
		return servicoResponseDTO;
	}
	
}
