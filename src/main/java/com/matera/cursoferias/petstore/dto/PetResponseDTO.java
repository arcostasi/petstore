package com.matera.cursoferias.petstore.dto;

import java.time.LocalDate;

public class PetResponseDTO {

	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private EspecieResponseDTO especie;
	private ClienteResponseDTO cliente;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EspecieResponseDTO getEspecie() {
		return especie;
	}

	public void setEspecie(EspecieResponseDTO especie) {
		this.especie = especie;
	}

	public ClienteResponseDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteResponseDTO cliente) {
		this.cliente = cliente;
	}
	
}
