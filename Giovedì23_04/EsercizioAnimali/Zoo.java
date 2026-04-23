package EsercizioAnimali;

import java.util.ArrayList;
import java.util.Scanner;

public class Zoo {

    public static void main(String[] args) {

        ArrayList<Animale> listaAnimali = new ArrayList<>();
        listaAnimali.add(new Cane("Baden", 8));
        listaAnimali.add(new Gatto("Bric", 3));
        listaAnimali.add(new Coccodrilli("Roberto", 150));

        for (Animale a : listaAnimali) {
            a.info();
        }

        System.out.println("\n--- Benvenuti nello Zoo! ---");
        Scanner scanner_string = new Scanner(System.in);
        Scanner scanner_int = new Scanner(System.in);
        ArrayList<Cane> cani = new ArrayList<>();
        ArrayList<Gatto> gatti = new ArrayList<>();
        ArrayList<Coccodrilli> coccodrilli = new ArrayList<>();
        int scelta;
        do {
            System.out.print("Scegli tipo (1: Cane, 2: Gatto, 3: Coccodrillo, 0: Chiudi programma): ");
            scelta = scanner_int.nextInt();
            if (scelta != 0) {
                System.out.print("Nome: ");
                String nome = scanner_string.nextLine();
                System.out.print("Età: ");
                int eta = scanner_int.nextInt();

                switch (scelta) {
                    case 1 -> {
                        Cane cane = new Cane(nome, eta);
                        cani.add(cane);
                        listaAnimali.add(cane);
                    }
                    case 2 -> {
                        Gatto gatto = new Gatto(nome, eta);
                        gatti.add(gatto);
                        listaAnimali.add(gatto);
                    }
                    case 3 -> {
                        Coccodrilli cocco = new Coccodrilli(nome, eta);
                        coccodrilli.add(cocco);
                        listaAnimali.add(cocco);
                    }
                    default ->
                        System.out.println("Scelta non valida!");
                }
            } else {
                System.out.println("Programma in chiusura...");
            }
        } while (scelta != 0);

        System.out.println("\n--- Stato dello Zoo ---");
        System.out.println("\nCani presenti: " + cani.size());
        for (Cane c : cani) {
            c.info();
        }

        System.out.println("\nGatti presenti: " + gatti.size());
        for (Gatto g : gatti) {
            g.info();
        }

        System.out.println("\nCoccodrilli presenti: " + coccodrilli.size());
        for (Coccodrilli co : coccodrilli) {
            co.info();
        }

        System.out.println("\nAnimali presenti nello zoo: " + listaAnimali.size());
        for (Animale a : listaAnimali) {
            a.info();
        }

        scanner_int.close();
        scanner_string.close();

    }
}
