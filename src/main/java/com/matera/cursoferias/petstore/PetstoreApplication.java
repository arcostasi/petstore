package com.matera.cursoferias.petstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.matera.cursoferias.*"})
public class PetstoreApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(PetstoreApplication.class, args);
		
	}

}
