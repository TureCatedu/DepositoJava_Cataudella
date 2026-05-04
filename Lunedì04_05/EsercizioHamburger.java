
import java.util.Scanner;

public class EsercizioHamburger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totaleConto = 0;
        char continuaOrdine = ' ';

        System.out.println("=== BENVENUTO DA JAVA BURGER ===");

        do {
            Hamburger mioBurger = null;
            System.out.println("\n--- NUOVO PANINO ---");
            System.out.println("1. Scegli un Hamburger Speciale");
            System.out.println("2. Crea il tuo Hamburger personalizzato");
            System.out.print("Scelta: ");

            int sceltaIniziale = scanner.nextInt();

            if (sceltaIniziale == 1) {

                System.out.println("\n--- MENU SPECIALI ---");
                System.out.println("1. Crispy McBacon (Salsa crispy + bacon + formaggio + patatine) - prezzo: 8,30.");
                System.out.println("2. Double Deluxe (Hamburger Classico doppio (250gr) + formaggio + lattuga + maionese + patatine) - prezzo: 11,30.");
                System.out.println("3. Torna indietro.");

                System.out.print("Scelta: ");
                int sceltaSpeciale = scanner.nextInt();

                mioBurger = new BaseBurger();
                switch (sceltaSpeciale) {
                    case 1 ->
                        mioBurger = new CrispySauce(new Bacon(new Cheese(new Fries(mioBurger))));
                    case 2 ->
                        mioBurger = new Maio(new Salad(new Cheese(new DoubleBurger(new Fries(mioBurger)))));
                    case 3 -> {
                        System.out.println("Nessun panino scelto. Ripropongo il menù.");
                        continue;
                    }
                    default ->
                        System.out.println("Scelta non valida.");
                }
            } else {

                mioBurger = new BaseBurger();
                boolean aggiuntaFinita = false;

                while (!aggiuntaFinita) {
                    System.out.println("\nConfigurazione: " + mioBurger.getDescrizione());
                    System.out.println("Prezzo attuale: €" + String.format("%.2f", mioBurger.getPrezzo()));
                    System.out.println("Aggiungi: \n1. Cheese + €0.50\n2. Bacon + €1\n3. Crispy sauce + €0.30\n4. Cipolla + €0.50\n5. Double + €3.50\n6. Maio + €0.30\n7. Ketchup + €0.30\n8. Lattuga + €0.50\n9. Patatine + €1\n0. FINE");
                    System.out.print("Scelta: ");

                    int ingrediente = scanner.nextInt();

                    switch (ingrediente) {
                        case 1 ->
                            mioBurger = new Cheese(mioBurger);
                        case 2 ->
                            mioBurger = new Bacon(mioBurger);
                        case 3 ->
                            mioBurger = new CrispySauce(mioBurger);
                        case 4 ->
                            mioBurger = new Onion(mioBurger);
                        case 5 ->
                            mioBurger = new DoubleBurger(mioBurger);
                        case 6 ->
                            mioBurger = new Maio(mioBurger);
                        case 7 ->
                            mioBurger = new Ket(mioBurger);
                        case 8 ->
                            mioBurger = new Salad(mioBurger);
                        case 9 ->
                            mioBurger = new Fries(mioBurger);
                        case 0 ->
                            aggiuntaFinita = true;
                        default ->
                            System.out.println("Ingrediente non valido!");
                    }
                }
            }
            if (mioBurger != null) {
                System.out.println("\n> PANINO AGGIUNTO: " + mioBurger.getDescrizione());
                System.out.println("> PREZZO PANINO: €" + mioBurger.getPrezzo());
                totaleConto += mioBurger.getPrezzo();
            }

            System.out.print("\nVuoi ordinare ancora? (s/n): ");
            continuaOrdine = scanner.next().toLowerCase().charAt(0);

        } while (continuaOrdine == 's');

        System.out.println("\n================================");
        System.out.println("RECONTO FINALE ORDINE");
        System.out.println("TOTALE COMPLESSIVO: €" + totaleConto);
        System.out.println("Grazie e a presto!");
        System.out.println("================================");

        scanner.close();
    }

    interface Hamburger {

        String getDescrizione();

        double getPrezzo();
    }

    static class BaseBurger implements Hamburger {

        @Override
        public String getDescrizione() {
            return "Hamburger Classico";
        }

        @Override
        public double getPrezzo() {
            return 5.00;
        }
    }

    static abstract class DecoratorBurger implements Hamburger {

        protected Hamburger hamburger;

        public DecoratorBurger(Hamburger hamburger) {
            this.hamburger = hamburger;
        }
    }

    static class Cheese extends DecoratorBurger {

        public Cheese(Hamburger hamburger) {
            super(hamburger);
        }

        @Override
        public String getDescrizione() {
            return hamburger.getDescrizione() + " + formaggio";
        }

        @Override
        public double getPrezzo() {
            return hamburger.getPrezzo() + 0.50;
        }

    }

    static class Bacon extends DecoratorBurger {

        public Bacon(Hamburger hamburger) {
            super(hamburger);
        }

        @Override
        public String getDescrizione() {
            return hamburger.getDescrizione() + " + bacon";
        }

        @Override
        public double getPrezzo() {
            return hamburger.getPrezzo() + 1.0;
        }

    }

    static class CrispySauce extends DecoratorBurger {

        public CrispySauce(Hamburger hamburger) {
            super(hamburger);
        }

        @Override
        public String getDescrizione() {
            return hamburger.getDescrizione() + " + salsa crispy";
        }

        @Override
        public double getPrezzo() {
            return hamburger.getPrezzo() + 0.30;
        }

    }

    static class Onion extends DecoratorBurger {

        public Onion(Hamburger hamburger) {
            super(hamburger);
        }

        @Override
        public String getDescrizione() {
            return hamburger.getDescrizione() + " + cipolla";
        }

        @Override
        public double getPrezzo() {
            return hamburger.getPrezzo() + 0.50;
        }

    }

    static class DoubleBurger extends DecoratorBurger {

        public DoubleBurger(Hamburger hamburger) {
            super(hamburger);
        }

        @Override
        public String getDescrizione() {
            return hamburger.getDescrizione() + " doppio (250gr)";
        }

        @Override
        public double getPrezzo() {
            return hamburger.getPrezzo() + 3.50;
        }

    }

    static class Maio extends DecoratorBurger {

        public Maio(Hamburger hamburger) {
            super(hamburger);
        }

        @Override
        public String getDescrizione() {
            return hamburger.getDescrizione() + " + maionese";
        }

        @Override
        public double getPrezzo() {
            return hamburger.getPrezzo() + 0.30;
        }

    }

    static class Ket extends DecoratorBurger {

        public Ket(Hamburger hamburger) {
            super(hamburger);
        }

        @Override
        public String getDescrizione() {
            return hamburger.getDescrizione() + " + ketchup";
        }

        @Override
        public double getPrezzo() {
            return hamburger.getPrezzo() + 0.30;
        }

    }

    static class Salad extends DecoratorBurger {

        public Salad(Hamburger hamburger) {
            super(hamburger);
        }

        @Override
        public String getDescrizione() {
            return hamburger.getDescrizione() + " + lattuga";
        }

        @Override
        public double getPrezzo() {
            return hamburger.getPrezzo() + 0.50;
        }

    }

    static class Fries extends DecoratorBurger {

        public Fries(Hamburger hamburger) {
            super(hamburger);
        }

        @Override
        public String getDescrizione() {
            return hamburger.getDescrizione() + " + patatine fritte";
        }

        @Override
        public double getPrezzo() {
            return hamburger.getPrezzo() + 1.50;
        }

    }

}
