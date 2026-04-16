import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioCompleto {
    public static void main(String[] args) {

        int input_int;
        //utilizzo una variabile in più per avere sempre sotto controllo la quantità di voti e utilizzare inputint per tutti gli altri input.
        int num_voti;
        //variabile booleana per gestire il ciclo booleano
        boolean again = true;
        Scanner scanner_int = new Scanner(System.in);
        ArrayList<Integer> listaVoti = new ArrayList<>();

        System.out.println("\nQuanti voti vuoi inserire?");
        num_voti = scanner_int.nextInt();

        for (int i = 0; i < num_voti; i++) {
            System.out.println("\nDigita i voti uno alla volta (0 < x <= 10): ");
            input_int = scanner_int.nextInt();
            if (input_int > 0 && input_int <= 10) {
                listaVoti.add(input_int);
                System.out.println("\nVoto aggiunto con successo!");
            } else {
                System.out.println("\nVoto non valido rispetta la condizione 0 < x <= 10.");
                i -= 1;
            }
        }

        do {
            System.out.println("\nElenco azioni disponibili:\n1 - Calcola media.\n2 - Trova il voto massimo.\n3 - Trova il voto minimo.\n4 - Verifica promozione.\n5- Esci dal programma.\n");
            input_int = scanner_int.nextInt();
            switch (input_int) {
                case 1:
                    System.out.println("\nLa media è: " + calcolaMedia(listaVoti, num_voti));;
                    break;
                case 2:
                    System.out.println("\nIl massimo voto è: " + trovaMax(listaVoti));
                    break;
                case 3:
                    System.out.println("\nIl minimo voto è: " + trovaMin(listaVoti));
                    break;
                case 4:
                    if(isPromosso(listaVoti, num_voti))
                    {
                        System.out.println("\nLo studente è promosso!");
                    }
                    else{
                        System.out.println("\nLo studente è bocciato!");
                    }
                case 5:
                    System.out.println("Programma chiuso con successo.");
                    again = false;
                    break;
                default:
                    break;
            }
        } while (again);
    }

    public static double calcolaMedia(ArrayList<Integer> lista, int num_voti) {
        int somma = 0;
        double media = 0.0d;

        for (Integer i : lista) {
            somma += i;
        }
        media = somma / num_voti;
        return media;
    }

    public static int trovaMax(ArrayList<Integer> lista) {
        int max = 0;
        for(Integer i : lista)
        {
            if(i>max) max = i;
        }
        return max;
    }

    public static int trovaMin(ArrayList<Integer> lista) {
        int min = 100;
        for(Integer i : lista)
        {
            if(i<min) min = i;
        }
        return min;
    }
    
    public static boolean isPromosso(ArrayList<Integer> lista, int media) {
        boolean promosso = false;
        if(calcolaMedia(lista, media)>=6) promosso = true;
        return promosso;
    }
}