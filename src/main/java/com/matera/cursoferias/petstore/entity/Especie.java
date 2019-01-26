package com.matera.cursoferias.petstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="Especie")
public class Especie extends BaseEntity {

	@Column(length=50, nullable=false)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
