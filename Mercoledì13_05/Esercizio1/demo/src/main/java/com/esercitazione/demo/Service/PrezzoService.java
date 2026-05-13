package com.esercitazione.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class PrezzoService {

    public double calcolaPrezzoScontato(double prezzoOriginale, int percentualeSconto) {
        if (percentualeSconto < 0 || percentualeSconto > 100) {
            System.out.println("Percentuale sconto non valida");
            return prezzoOriginale;
        }
        return prezzoOriginale * (1 - (percentualeSconto / 100.0));
    }
}