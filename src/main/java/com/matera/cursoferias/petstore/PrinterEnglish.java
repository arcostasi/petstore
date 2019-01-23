package com.matera.cursoferias.petstore;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class PrinterEnglish implements Printer {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Hello World!!!");
	}

}
