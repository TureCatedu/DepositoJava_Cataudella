package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Configuration
 * Questa annotazione indica che la classe è una "sorgente di configurazione".
 * Spring leggerà questa classe per trovare definizioni di Bean da caricare
 * nel suo Application Context (il contenitore dove vivono gli oggetti gestiti da Spring).
 */
@Configuration
public class AppConfig {

    /**
     * @Bean
     * Indica che questo metodo restituisce un oggetto che Spring deve gestire.
     * RestTemplate è una classe di Spring usata per effettuare chiamate HTTP sincrone
     * (es. consumare dati da un'altra API REST in formato JSON).
     *
     * Una volta definito qui, puoi iniettarlo ovunque con @Autowired.
     */
    @Bean
    public RestTemplate restTemplate() {
        // Inizializza e restituisce una nuova istanza di RestTemplate
        return new RestTemplate();
    }
}
