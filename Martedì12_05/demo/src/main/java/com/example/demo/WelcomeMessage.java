package com.example.demo;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * @Component
 * Questa annotazione dice a Spring: "Questa è una classe speciale (un Bean)".
 * All'avvio, Spring creerà automaticamente un'istanza di questa classe
 * e la terrà nel suo "contenitore" per poterla iniettare dove serve.
 */
@Component
public class WelcomeMessage {

    // Semplice metodo che restituisce una stringa
    public String getMessage() {
        return "Welcome to Spring Boot!!!";
    }

    /**
     * @PostConstruct
     * Questo metodo viene eseguito AUTOMATICAMENTE subito dopo che Spring
     * ha creato l'oggetto (Bean) e ha iniettato tutte le dipendenze.
     * È il posto ideale per logiche di inizializzazione o log di avvio.
     */
    @PostConstruct
    public void init() {
        System.out.println("--- LOG: Il Bean WelcomeMessage è stato creato e inizializzato! ---");
    }

    /**
     * @PreDestroy
     * Questo metodo viene eseguito AUTOMATICAMENTE un istante prima che
     * l'applicazione venga chiusa o che il Bean venga rimosso dal contenitore.
     * Si usa per "pulire" le risorse (es. chiudere file aperti o connessioni).
     */
    @PreDestroy
    public void destroy() {
        System.out.println("--- LOG: L'applicazione si sta chiudendo. Pulizia del Bean in corso... ---");
    }
}