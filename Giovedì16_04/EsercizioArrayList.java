
import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioArrayList {

    public static void main(String[] args) {
        Scanner scanner_string = new Scanner(System.in);
        Scanner scanner_int = new Scanner(System.in);
        ArrayList<String> listaStudenti = new ArrayList<>();
        boolean again = true;
        String input_string;
        int input_int;

        System.out.println("\nVuoi aggiungere nuovi studenti all'elenco? (s/n)");
        input_string = scanner_string.nextLine();

        if (input_string.equalsIgnoreCase("s")) {
            do {
                System.out.println("\nScrivi il nome dello studente da aggiungere e invia, quando non vuoi aggiungere più studenti invia 'fine'. (Aggiungi uno studente alla volta) ");
                input_string = scanner_string.nextLine();

                if (input_string.equalsIgnoreCase("fine")) {
                    again = false;
                } else {
                    listaStudenti.add(input_string);
                    System.out.println(" \n ------------ Aggiunto " + input_string + " alla lista ------------ ");
                }

            } while (again);

            again = true;

            do {
                //creo l'elenco delle azioni possibili e gestino i vari casi con lo switch
                System.out.println("\nScegli dall'elenco e seleziona l'azione con il numero corrispondente: \n1. Stampa i nomi della lista in ordine alfabetico.\n2. Conta il numero di studenti presenti nella lista.\n3. Elimina uno studente dalla lista.\n4. Esci dal programma.");
                input_int = scanner_int.nextInt();

                switch (input_int) {
                    case 1:
                        //ordine alfabetico
                        listaStudenti.sort(null);
                        for (String i : listaStudenti) {
                            System.out.println("\n" + i);
                        }

                        break;
                    case 2:
                        //numero di studenti
                        System.out.println("\n La lista di studenti comprende " + listaStudenti.size() + " studenti.");
                        break;
                    case 3:
                        //devo controllare se c'è lo studente prima di rimuovere.
                        System.out.println("\nQuale studente vuoi rimuovere?");
                        for (String i : listaStudenti) {
                            System.out.println("\n" + i);
                        }
                        input_string = scanner_string.nextLine();
                        boolean trovato = false;
                        for (String i : listaStudenti) {
                            if (i.equalsIgnoreCase(input_string)) {
                                listaStudenti.remove(input_string);
                                System.out.println("\n----------- " + input_string + " rimosso con successo -----------");
                            }
                        }
                        if (!trovato) {
                            System.out.println("\nStudente non presnte nella lista, impossibile da rimuovere.");
                        }
                        break;
                    case 4:
                        again = false;
                        System.out.println("Programma in chiusura.");
                    default:
                        break;
                }
            } while (again);
        } else {
            System.out.println("\nInserimento bloccato.");
        }
        scanner_int.close();
        scanner_string.close();
    }
}