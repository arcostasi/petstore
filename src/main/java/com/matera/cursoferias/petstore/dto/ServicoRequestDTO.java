package com.matera.cursoferias.petstore.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ServicoRequestDTO {

	private String observacao;
	
	@JsonFormat(pattern = "dd/MM/yyy HH:mm:ss")
	private LocalDateTime dataHora;
	
	private String tipoServico;
	private BigDecimal valor;
	private Long idPet;
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
	public String getTipoServico() {
		return tipoServico;
	}
	
	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public Long getIdPet() {
		return idPet;
	}
	
	public void setIdPet(Long idPet) {
		this.idPet = idPet;
	}

}
