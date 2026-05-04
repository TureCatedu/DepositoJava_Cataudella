package PiattaformeNotifiche;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // Ottenimento dell'istanza unica del NotificationManager tramite il pattern Singleton
        Singleton manager = Singleton.getInstance();
        Scanner scanner = new Scanner(System.in);

        // Lista locale per monitorare gli oggetti UtenteBase creati (utile per la ricerca per nome)
        ArrayList<UtenteBase> registroUtenti = new ArrayList<>();

        while (true) {
            System.out.println("\n=== GESTORE NOTIFICHE ===");
            System.out.println("1. Iscrivi nuovo utente");
            System.out.println("2. Disiscrivi utente per nome");
            System.out.println("3. Invia messaggio globale");
            System.out.println("4. Elenco iscritti");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");

            String scelta = scanner.nextLine();

            switch (scelta) {
                case "1" -> {
                    System.out.print("Inserisci nome utente: ");
                    String nome = scanner.nextLine();

                    // Creazione dell'oggetto "Concrete Observer" base
                    UtenteBase utente = new UtenteBase(nome);

                    System.out.println("Scegli formato: [1] Standard [2] Maiuscolo [3] Timestamp + Maiuscolo");
                    String opzione = scanner.nextLine();

                    // Variabile polimorfica che conterrà l'utente (eventualmente decorato)
                    Observer utenteFinale;

                    // Applicazione del Pattern Decorator in base alla scelta dell'utente
                    switch (opzione) {
                        case "2" -> 
                            // Avvolge l'utente base con il decoratore per il maiuscolo
                            utenteFinale = new UpperCaseDecorator(utente);

                        case "3" -> 
                            // Composizione multipla di decoratori (Chain of Responsibility dinamica)
                            utenteFinale = new TimestampDecorator(new UpperCaseDecorator(utente));
                        
                        default -> {
                            // Nessun decoratore applicato
                            utenteFinale = utente;
                            if (!opzione.equals("1")) {
                                System.out.println("Opzione non valida, impostato formato Standard di default.");
                            }
                        }
                    }

                    // Registrazione dell'Observer presso il Subject (Singleton)
                    manager.iscrivi(utenteFinale);
                    // Salvataggio nel registro locale per la gestione futura (rimozione)
                    registroUtenti.add(utente);
                    System.out.println("Utente '" + nome + "' aggiunto con successo.");
                }

                case "2" -> {
                    System.out.print("Nome dell'utente da rimuovere: ");
                    String nomeDaRimuovere = scanner.nextLine();

                    UtenteBase riferimentoBase = null;

                    // Ricerca dell'utente nell'ArrayList tramite confronto stringhe
                    for (UtenteBase u : registroUtenti) {
                        if (u.getNome().equalsIgnoreCase(nomeDaRimuovere)) {
                            riferimentoBase = u;
                            break;
                        }
                    }

                    if (riferimentoBase != null) {
                        // Rimozione dell'utente dal pattern Observer
                        manager.disiscrivi(riferimentoBase);
                        // Pulizia della lista locale
                        registroUtenti.remove(riferimentoBase);
                        // Rimozione forzata dalla lista interna del manager (se accessibile direttamente)
                        manager.getUtenti().remove(riferimentoBase);
                        System.out.println("Utente rimosso.");
                    } else {
                        System.out.println("Utente non trovato.");
                    }
                }

                case "3" -> {
                    // Invio della notifica a tutti gli osservatori registrati tramite il Singleton
                    System.out.print("Testo notifica: ");
                    manager.inviaNotifica(scanner.nextLine());
                }

                case "4" -> {
                    // Semplice ciclo per visualizzare i nomi degli utenti nell'ArrayList
                    System.out.println("Utenti in lista:");
                    for (UtenteBase u : registroUtenti) {
                        System.out.println("- " + u.getNome());
                    }
                }

                case "5" -> {
                    System.out.println("Applicazione in chiusura...");
                    return;
                }
            }
        }
    }
}