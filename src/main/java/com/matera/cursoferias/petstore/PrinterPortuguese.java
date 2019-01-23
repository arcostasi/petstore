package com.matera.cursoferias.petstore;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class PrinterPortuguese implements Printer {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Olá Mundo!!!");
	}

}
