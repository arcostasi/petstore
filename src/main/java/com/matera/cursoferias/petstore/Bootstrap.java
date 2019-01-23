package com.matera.cursoferias.petstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

	@Qualifier("printerEnglish")
	@Autowired
	private Printer printer;
	
	@Override
	public void run(String... args) throws Exception {
		printer.print();
	}

}
