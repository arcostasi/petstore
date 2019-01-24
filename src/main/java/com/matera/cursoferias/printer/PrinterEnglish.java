package com.matera.cursoferias.printer;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("en")
public class PrinterEnglish implements Printer {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Hello World!!!");
	}

}
