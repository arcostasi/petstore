package com.matera.cursoferias.printer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// @Primary
@Component
@Profile("pt")
public class PrinterPortuguese implements Printer {

	@Value("${print.message}")
	private String message;
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

}
