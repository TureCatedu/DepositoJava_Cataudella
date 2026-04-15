import java.util.Scanner;

public class EsercizioValutazioneVoti {

    public static void main(String[] args) {
        int num_voti;
        Scanner myObj_int = new Scanner(System.in);
        Scanner myObj_String = new Scanner(System.in);
        int voto;
        String listaVoti = "";
        String input;
        do {
            System.out.println("Vuoi inseerire dei voti? (s/n)");
            input = myObj_String.nextLine();
            do{
            System.out.println("Quanti voti vuoi inserire? ( > 0)");
            num_voti = myObj_int.nextInt();
            if (num_voti > 0) {
                for (int i = 1; i <= num_voti; i++) {
                    System.err.println("Voto da inserire (deve essere 0 < x < 30): ");
                    voto = myObj_int.nextInt();
                    if (voto > 30 || voto < 0) {
                        System.out.println("Voto non valido (deve essere 0 < x < 30).");
                        i -= 1;
                    } else if (voto >= 24) {
                        System.out.println("Voto " + voto + " ottimo. Inserito nel registro.");
                        listaVoti = listaVoti + voto + " ";
                    } else if (voto >= 18) {
                        System.out.println("Voto " + voto + " sufficiente. Inserito nel registro.");
                        listaVoti = listaVoti + voto + " ";
                    } else {
                        System.out.println("Voto " + voto + " Insufficiente");
                        listaVoti = listaVoti + voto + " ";
                    }
                }
                System.out.println("\nVoti aggiunti: " + listaVoti);
            } else {
                System.out.println("Numero voti <= 0 non valido. Restart del programma in corso...");
            }
        } while(num_voti > 0);
    }while (input.equalsIgnoreCase("n"));
    }
}
