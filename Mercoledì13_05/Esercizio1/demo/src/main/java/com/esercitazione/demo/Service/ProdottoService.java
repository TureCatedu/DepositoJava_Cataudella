package com.esercitazione.demo.Service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProdottoService {

    private final PrezzoService prezzoService;
    private final List<String> nomiProdotti = new ArrayList<>();
    private final Map<String, Double> prezziProdotti = new HashMap<>();

    // Iniezione via costruttore
    public ProdottoService(PrezzoService prezzoService) {
        this.prezzoService = prezzoService;
    }

    @PostConstruct
    public void init() {
        aggiungiProdotto("Laptop Pro 15\"", 1299.99);
        aggiungiProdotto("Mouse Wireless", 49.90);
        aggiungiProdotto("Tastiera Meccanica", 129.50);
        aggiungiProdotto("Monitor 4K 27\"", 549.00);

        System.out.println("[ProdottoService] Catalogo inizializzato con " + nomiProdotti.size() + " prodotti.");
    }

    private void aggiungiProdotto(String nome, double prezzo) {
        nomiProdotti.add(nome);
        prezziProdotti.put(nome, prezzo);
    }

    public void stampaCatalogo(int percentualeSconto) {
        System.out.println("\n========================================");
        System.out.printf("  CATALOGO PRODOTTI — Sconto: %d%%%n", percentualeSconto);
        System.out.println("========================================");

        for (String nome : nomiProdotti) {
            double prezzoOriginale = prezziProdotti.get(nome);
            double prezzoScontato = prezzoService.calcolaPrezzoScontato(prezzoOriginale, percentualeSconto);

            System.out.printf("  %-20s  %8.2f€  →  %8.2f€%n",
                    nome, prezzoOriginale, prezzoScontato);
        }
        System.out.println("========================================\n");
    }
}