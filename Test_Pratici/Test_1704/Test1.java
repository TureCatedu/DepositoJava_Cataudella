
import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {
    //variabili istanziate globalmenete come attributi della classe così da essere accessibili ovunque senza 
    //l'utilizzo di passaggio di parametri ma come attributi della classe

    //liste per la gestione Utenti
    static ArrayList<String> nomiUtenti = new ArrayList<>();
    static ArrayList<String> passwordUtenti = new ArrayList<>();

    //liste per la cronologia Calcolatrice
    static ArrayList<Double> valoriInseriti = new ArrayList<>();
    static ArrayList<Double> risultatiOperazioni = new ArrayList<>();
    static ArrayList<String> operazioniEffettuate = new ArrayList<>();

    //input diversi per gestire meglio lo scanner
    static Scanner input_string = new Scanner(System.in);
    static Scanner input_int = new Scanner(System.in);

    //variabile per gestire log2
    static String utenteLoggato = null;

    //contatore per limite di 4
    static int contatoreOperazioni = 0;

    public static void main(String[] args) {
        int scelta;
        accounTest();
        do {
            if (utenteLoggato!=null) {
                System.out.println("\n--- MENU PRINCIPALE ---\n1. Registrazione Utente\n2. Login\n3. Calcolatrice\n4. Visualizza Cronologia\n5. Cambia account (ATTENZIONE AZIONE IRREVERSIBILE: perdi i dati delle operazioni effettuate precedentemente!)\n0. Esci\n\nScelta: ");

            } else {
                System.out.println("\n--- MENU PRINCIPALE (LOGIN NECESSARIO) ---\n1. Registrazione Utente\n2. Login\n3. Calcolatrice\n4. Visualizza Cronologia\n0. Esci\n\nScelta: ");
            }

            scelta = input_int.nextInt();
            switch (scelta) {
                case 1:
                    registraUtente();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    menuCalcolatrice();
                    break;
                case 4:
                    visualizzaCronologia();
                    break;
                case 5:
                    utenteLoggato = null;
                    operazioniEffettuate.clear();
                    risultatiOperazioni.clear();
                    valoriInseriti.clear();
                case 0:
                    System.out.println("Chiusura...");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);
    }

    //funzione accounTest per fare login velocemente dal creatore del programma con password e nomeUtente saltando la registrazione
    private static void accounTest() {
        nomiUtenti.add("a");
        passwordUtenti.add("1");
    }

    //funzioni user
    static void registraUtente() {
        System.out.print("Inserisci nome utente: ");
        String nome = input_string.nextLine();

        if (nomiUtenti.contains(nome)) {
            System.out.println("Errore: Utente già esistente!");
        } else {
            System.out.print("Inserisci password: ");
            String pass = input_string.nextLine();
            nomiUtenti.add(nome);
            passwordUtenti.add(pass);
            System.out.println("Registrazione completata.");
        }
    }

    static void login() {
        System.out.print("Nome utente: ");
        String nome = input_string.nextLine();
        System.out.print("Password: ");
        String pass = input_string.nextLine();

        int index = nomiUtenti.indexOf(nome);

        //index != -1 perché il metodo indexOf restituisce -1 quando non trova l'elemento cercato.
        if (index != -1 && passwordUtenti.get(index).equals(pass)) {
            utenteLoggato = nome;
            contatoreOperazioni = 0; //numero di operazioni effettuate resettato per il nuovo login
            System.out.println("\nLogin effettuato con successo! Benvenuto " + nome);
        } else {
            System.out.println("Nome Utente e/o password errate.");
        }
    }

    //funzioni calcolatrice
    static void menuCalcolatrice() {
        if (utenteLoggato == null) {
            System.out.println("Devi loggarti per usare la calcolatrice!");
            return;
        }

        if (contatoreOperazioni >= 4) {
            System.out.println("Limite operazioni raggiunto. Logout automatico...");
            utenteLoggato = null;
            return;
        }

        System.out.println("\n--- CALCOLATRICE (Operazioni effettuate: " + contatoreOperazioni + "/4) ---");
        System.out.println("1. Somma | 2. Sottrazione | 3. Moltiplicazione | 4. Divisione | 5. Media");
        int op = input_int.nextInt();

        System.out.print("Quanti numeri vuoi inserire? ");
        int x = input_int.nextInt();

        //array dei numeri da utilizzare nelle operazioni della diimensione "scelta" dall'utente, fondamentale per l'utilizzo di for each
        double[] numeri = new double[x];

        for (int i = 0; i < x; i++) {
            System.out.print("Inserisci numero " + (i + 1) + ": ");
            numeri[i] = input_int.nextDouble();
            valoriInseriti.add(numeri[i]); //salvo i numeri globalmente
        }

        double risultato = 0;
        switch (op) {
            case 1:
                for (double n : numeri) {
                    risultato += n;
                }
                operazioniEffettuate.add(" - Somma di " + x + " numeri. - ");
                break;
            case 2:
                //risultato assume il valore del primo numero e in ordine vengono sottratti i successivi
                risultato = numeri[0];
                for (int i = 1; i < x; i++) {
                    risultato -= numeri[i];
                }
                operazioniEffettuate.add(" - Sottrazione di " + x + " numeri. - ");
                break;
            case 3:
                //risultato assume un valore "neutro"
                risultato = 1;
                for (double n : numeri) {
                    risultato *= n;
                }
                operazioniEffettuate.add(" - Moltiplicazione di " + x + " numeri. - ");
                break;
            case 4:
                //vale lo stesso rispetto alla sottrazione in quanto è importante l'ordine in cui avvengono  le operazioni
                risultato = numeri[0];
                for (int i = 1; i < x; i++) {
                    if (numeri[i] != 0) {
                        risultato /= numeri[i];
                    } else {
                        System.out.println(" - Divisione per zero saltata. - ");
                    }
                }
                operazioniEffettuate.add(" - Divisione di " + x + " numeri. - ");
                break;
            case 5:
                double somma = 0;
                for (double n : numeri) {
                    somma += n;
                }
                risultato = somma / x;
                operazioniEffettuate.add(" - Media di " + x + " numeri. - ");
                break;
            default:
                System.out.println("Operazione non valida.");
                return;
        }

        risultatiOperazioni.add(risultato);
        contatoreOperazioni++;
        System.out.println("Risultato: " + risultato);

        if (contatoreOperazioni >= 4) {
            System.out.println("Hai raggiunto il limite di 4 operazioni. Utente disconnesso...");
            //aggiorno variabile booleana per disconnessione dell'utente
            utenteLoggato = null;
        }
    }

    static void visualizzaCronologia() {
        //la cronologia è visibile sollo se l'utente è loggato
        if (utenteLoggato == null) {
            System.out.println("Accesso negato. Effettua il login.");
            return;
        }
        System.out.println("\n--- CRONOLOGIA VALORI INSERITI ---");
        System.out.println(valoriInseriti);
        System.out.println("--- CRONOLOGIA RISULTATI ---");
        System.out.println(risultatiOperazioni);
        System.out.println("--- CRONOLOGIA OPERAZIONI EFFETTUATE ---");
        System.out.println(operazioniEffettuate);
    }
}