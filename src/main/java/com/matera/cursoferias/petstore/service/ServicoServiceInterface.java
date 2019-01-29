package com.matera.cursoferias.petstore.service;

import com.matera.cursoferias.petstore.dto.ServicoRequestDTO;
import com.matera.cursoferias.petstore.dto.ServicoResponseDTO;
import com.matera.cursoferias.petstore.entity.Servico;

public interface ServicoServiceInterface  extends CrudServiceInterface<ServicoRequestDTO, ServicoResponseDTO, Servico,  Long> {

}
