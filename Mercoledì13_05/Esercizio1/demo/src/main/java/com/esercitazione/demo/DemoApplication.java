package com.esercitazione.demo;

import com.esercitazione.demo.Service.ProdottoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ProdottoService prodottoService) {
		return args -> {
			prodottoService.stampaCatalogo(20);
		};
	}
}