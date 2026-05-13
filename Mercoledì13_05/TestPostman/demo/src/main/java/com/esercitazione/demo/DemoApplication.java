package com.esercitazione.demo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.esercitazione.demo.controller.RunController;
import com.esercitazione.demo.run.Location;
import com.esercitazione.demo.run.Run;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(RunController runController) {
        return args -> {
            // Creazione della prima corsa
            Run run1 = new Run(
                1,
                "Corsa Mattutina",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                5.5,
                Location.OUTDOOR
            );

            // Creazione della seconda corsa
            Run run2 = new Run(
                2,
                "Sessione Serale",
                LocalDateTime.now(),
                LocalDateTime.now().plus(60, ChronoUnit.MINUTES),
                10.0,
                Location.INDOOR
            );

            // Aggiunta al controller (che gestisce la tua lista in memoria)
            runController.create(run1);
            runController.create(run2);

            System.out.println("--- Dati iniziali caricati con successo! ---");
        };
    }
}