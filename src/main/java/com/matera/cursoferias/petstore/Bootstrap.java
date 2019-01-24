package com.matera.cursoferias.petstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.matera.cursoferias.petstore.entity.Especie;
import com.matera.cursoferias.petstore.repository.EspecieRepository;
import com.matera.cursoferias.printer.Printer;

@Component
public class Bootstrap implements CommandLineRunner {

//	@Qualifier("printerEnglish")
//	@Autowired
//	private Printer printerEnglish;
//	
//	@Autowired
//	private Printer printerPortuguese;
	
	@Autowired
	private Printer printer;
	
	@Autowired
	private EspecieRepository especieRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		printerPortuguese.print();
//		printerEnglish.print();
		
		// Definido em application.properties em resources
		printer.print();
		
		Especie especie1 = new Especie();
		especie1.setDescricao("Cachorro");
				
		especieRepository.save(especie1);
	}

}
