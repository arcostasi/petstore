package com.matera.cursoferias.petstore.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.matera.cursoferias.petstore.business.ServicoBusiness;
import com.matera.cursoferias.petstore.dto.ServicoRequestDTO;
import com.matera.cursoferias.petstore.dto.ServicoResponseDTO;
import com.matera.cursoferias.petstore.entity.Servico;
import com.matera.cursoferias.petstore.entity.TipoServico;

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
	public Servico findEntityById(Long id) {
		return servicoBusiness.findById(id);
	}

	@Override
	public ServicoResponseDTO save(Long id, ServicoRequestDTO requestDTO) {
		Servico servico = convertRequestDTOToEntity(id, requestDTO);
		
		servico = servicoBusiness.save(servico);
		
		return convertEntityToResponseDTO(servico);
	}

	@Override
	public void deleteById(Long id) {
		servicoBusiness.deleteById(id);
	}
	
	@Override
	public List<ServicoResponseDTO> findByPet_Id(Long idPet) {
		List<Servico> servicos = servicoBusiness.findByPet_Id(idPet);

		return convertListEntityToListResponseDTO(servicos);
	}
	
	@Override
	public List<ServicoResponseDTO> findByDataHoraBetween(LocalDate dataInicial, LocalDate dataFinal) {
		List<Servico> servicos = servicoBusiness.findByDataHoraBetween(dataInicial.atTime(0, 0, 0), dataFinal.atTime(23, 59, 59));
		
		return convertListEntityToListResponseDTO(servicos);
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

	@Override
	public Servico convertRequestDTOToEntity(Long id, ServicoRequestDTO requestDTO) {
		Servico servico = id == null ? new Servico() : servicoBusiness.findById(id);
		
		servico.setDataHora(LocalDateTime.now());
		servico.setObservacao(requestDTO.getObservacao());
		servico.setPet(petService.findEntityById(requestDTO.getIdPet()));
		servico.setTipoServico(TipoServico.valueOf(requestDTO.getIdTipoServico()));
		servico.setValor(requestDTO.getValor());
		
		return servico;
	}
	
	private List<ServicoResponseDTO> convertListEntityToListResponseDTO(List<Servico> servicos) {
		List<ServicoResponseDTO> result = new ArrayList<>();
		
		servicos.forEach(servico -> result.add(convertEntityToResponseDTO(servico)));
		
		return result;
	}
	
}
