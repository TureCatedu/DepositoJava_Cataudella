package EsercizioComputerFullPattern;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Inizializzazione MVC

        // facade
        ComputerFacade model = new ComputerFacade();

        //view mvc
        ComputerView view = new ComputerView();

        // controller mvc
        ComputerController controller = new ComputerController(model, view);

        Scanner input = new Scanner(System.in);
        boolean continua = true;

        System.out.println("--- SISTEMA DI CONTROLLO COMPUTER ---");

        while (continua) {
            System.out.println("\nSeleziona modalità di avvio:");
            System.out.println("1. Avvio Standard (Strategy: Normal)");
            System.out.println("2. Avvio Provvisorio (Strategy: Safe)");
            System.out.println("3. Spegni simulatore");
            System.out.print("Scelta: ");

            String scelta = input.nextLine();

            switch (scelta) {
                case "1" ->
                    controller.avvioNormale();
                case "2" ->
                    controller.avvioProvvisorio();
                case "3" -> {
                    System.out.println("Chiusura del sistema...");
                    continua = false;
                }
                default ->
                    System.out.println("Opzione non valida, riprova.");
            }
        }

        input.close();
    }
}
