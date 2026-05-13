package com.example.demo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.run.Location;
import com.example.demo.run.RunRecord;
import com.example.demo.Service.OrderService;

/**
 * SPIEGAZIONE DELLE ANNOTAZIONI PRINCIPALI DI SPRING:
 *
 * 1. @Repository
 *    - Dove si usa: Sulle classi della logica di persistenza (DAO).
 *    - Scopo: Indica che la classe comunica con il Database. Spring gestisce
 *      automaticamente le eccezioni SQL e le traduce in eccezioni Java leggibili.
 *
 * 2. @Controller
 *    - Dove si usa: Sulle classi che gestiscono il traffico web MVC.
 *    - Scopo: Serve per restituire pagine HTML (View). Il metodo restituisce
 *      una Stringa che corrisponde al nome di un file .html (es. usando Thymeleaf).
 *
 * 3. @RestController
 *    - Dove si usa: Sulle classi che espongono API (Web Services).
 *    - Scopo: È un mix di @Controller + @ResponseBody. Non restituisce HTML,
 *      ma trasforma automaticamente i dati (come il nostro RunRecord) in JSON.
 */

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// Avvio dell'applicazione Spring Boot
		SpringApplication.run(DemoApplication.class, args);

		// --- Esempio pratico nel main ---
		WelcomeMessage message = new WelcomeMessage();
		System.out.println(message.getMessage());

		// Creazione di un Record (Immutabile)
		RunRecord runRecord = new RunRecord(
				1,
				"Corsa pomeridiana",
				LocalDateTime.now(),
				LocalDateTime.now().plus(45, ChronoUnit.MINUTES),
				10,
				Location.INDOOR
		);

		// Stampiamo un campo del record usando la sintassi record.nomeCampo()
		System.out.println("Esercizio registrato: " + runRecord.title());


		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		System.out.println("--- BEAN REGISTRATI ---");
		String[] beanNames = ctx.getBeanDefinitionNames();

		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}

	/**
	 * @Bean indica a Spring di creare questo oggetto all'avvio.
	 * CommandLineRunner esegue il codice subito dopo l'avvio del server.
	 */
	@Bean
	CommandLineRunner runner(OrderService orderService) {
		return args -> {
			System.out.println("--- LOG: Esecuzione CommandLineRunner ---");

			// Simulazione di un ordine processato tramite il Service
			orderService.processOrder("ORD-999");

			System.out.println("--- LOG: Fine esecuzione ---");
		};
	}



}