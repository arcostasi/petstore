package com.matera.cursoferias.petstore;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.matera.cursoferias.petstore.business.EspecieBusiness;
import com.matera.cursoferias.petstore.business.PetBusiness;
import com.matera.cursoferias.petstore.business.ServicoBusiness;
import com.matera.cursoferias.petstore.entity.Cliente;
import com.matera.cursoferias.petstore.entity.Especie;
import com.matera.cursoferias.petstore.entity.Pet;
import com.matera.cursoferias.petstore.entity.Servico;
import com.matera.cursoferias.petstore.entity.TipoServico;
import com.matera.cursoferias.petstore.repository.ClienteRepository;

@Component
public class DataInitializer implements CommandLineRunner {
	
	private final EspecieBusiness especieBusiness;
	private final ClienteRepository clienteBusiness;
	private final PetBusiness petBusiness;
	private final ServicoBusiness servicoBusiness;
	
	public DataInitializer(EspecieBusiness especieBusiness, 
			ClienteRepository clienteRepository,
			PetBusiness petBusiness,
			ServicoBusiness servicoBusiness) {
		this.especieBusiness = especieBusiness;
		this.clienteBusiness = clienteRepository;
		this.petBusiness = petBusiness;
		this.servicoBusiness = servicoBusiness;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Especie especie1 = new Especie();
		Especie especie2 = new Especie();
		
		especie1.setDescricao("Gato");
		especie2.setDescricao("Cachorro");
		
		especieBusiness.save(especie1);
		especieBusiness.save(especie2);
		
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		
		cliente1.setNome("Anderson");
		cliente2.setNome("Luciana");
		
		clienteBusiness.save(cliente1);
		clienteBusiness.save(cliente2);
		
		Pet pet1 = new Pet();
		Pet pet2 = new Pet();
		Pet pet3 = new Pet();
		Pet pet4 = new Pet();
		
		pet1.setNome("Lili");
		pet1.setDataNascimento(LocalDate.parse("2012-05-20"));
		pet1.setEspecie(especie1);
		pet1.setCliente(cliente1);
		
		pet2.setNome("Bob");
		pet2.setDataNascimento(LocalDate.parse("2010-07-11"));
		pet2.setEspecie(especie2);
		pet2.setCliente(cliente1);
		
		pet3.setNome("Teca");
		pet3.setDataNascimento(LocalDate.parse("2012-05-02"));
		pet3.setEspecie(especie2);
		pet3.setCliente(cliente2);
		
		pet4.setNome("Amora");
		pet4.setDataNascimento(LocalDate.parse("2014-10-30"));
		pet4.setEspecie(especie1);
		pet4.setCliente(cliente2);
		
		petBusiness.save(pet1);
		petBusiness.save(pet2);
		petBusiness.save(pet3);
		petBusiness.save(pet4);
		
		Servico servico1 = new Servico();
		Servico servico2 = new Servico();
		Servico servico3 = new Servico();
		Servico servico4 = new Servico();

		servico1.setDataHora(LocalDateTime.parse("2019-01-24T09:00:00"));
		servico1.setObservacao("Banho e tosa da Lili");
		servico1.setPet(pet1);
		servico1.setTipoServico(TipoServico.BANHO_TOSA);
		servico1.setValor(new BigDecimal("60.00"));
	
		servico2.setDataHora(LocalDateTime.parse("2019-01-24T09:00:00"));
		servico2.setObservacao("Vacinação do Bob");
		servico2.setPet(pet2);
		servico2.setTipoServico(TipoServico.VACINACAO);
		servico2.setValor(new BigDecimal("50.00"));
		
		servico3.setDataHora(LocalDateTime.parse("2019-01-24T13:30:00"));
		servico3.setObservacao("Cirurgia do Teca");
		servico3.setPet(pet3);
		servico3.setTipoServico(TipoServico.CIRURGIA);
		servico3.setValor(new BigDecimal("300.00"));
		
		servico4.setDataHora(LocalDateTime.parse("2019-01-24T15:00:00"));
		servico4.setObservacao("Consulta da Amora");
		servico4.setPet(pet4);
		servico4.setTipoServico(TipoServico.CONSULTA);
		servico4.setValor(new BigDecimal("30.00"));
		
		servicoBusiness.save(servico1);
		servicoBusiness.save(servico2);
		servicoBusiness.save(servico3);
		servicoBusiness.save(servico4);
		
		System.out.println("Criação dos dados finalizada.\n");
	}

}
