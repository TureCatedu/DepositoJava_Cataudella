import java.util.Scanner;

public class EsercizioMessTestoDeco {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BaseMessage messaggioBase = new BaseMessage("Messaggio iniziale");
        boolean continua = true;

        System.out.println("--- Gestore Messaggi Dinamico ---");

        while (continua) {
            System.out.println("\nTesto attuale: \"" + messaggioBase.getContenuto() + "\"");
            System.out.println("1) Cambia il testo");
            System.out.println("2) Visualizza originale");
            System.out.println("3) Trasforma in UPPERCASE");
            System.out.println("4) Trasforma in lowercase");
            System.out.println("0) Esci");
            System.out.print("Scelta: ");

            int scelta = input.nextInt();
            input.nextLine();

            switch (scelta) {
                case 1 -> {
                    System.out.print("Inserisci il nuovo testo: ");
                    String nuovoTesto = input.nextLine();
                    messaggioBase.setContenuto(nuovoTesto);
                    System.out.println("Testo aggiornato!");
                }
                case 2 -> 
                    System.out.println("Risultato: " + messaggioBase.getContenuto());
                case 3 -> {
                    Message upper = new UpperMessage(messaggioBase);
                    System.out.println("Risultato: " + upper.getContenuto());
                }
                case 4 -> {
                    Message lower = new LowerMessage(messaggioBase);
                    System.out.println("Risultato: " + lower.getContenuto());
                }
                case 0 -> {
                    System.out.println("Chiusura programma...");
                    continua = false;
                }
                default -> System.out.println("Opzione non valida!");
            }
        }
        input.close();
    }



    interface Message {
        String getContenuto();
    }

    static class BaseMessage implements Message {
        private String testo;

        public BaseMessage(String testo) {
            this.testo = testo;
        }

        public void setContenuto(String nuovoTesto) {
            this.testo = nuovoTesto;
        }

        @Override
        public String getContenuto() {
            return testo;
        }
    }

    static abstract class MessageDecorator implements Message {
        protected Message message;

        public MessageDecorator(Message message) {
            this.message = message;
        }
    }

    static class UpperMessage extends MessageDecorator {
        public UpperMessage(Message message) { super(message); }

        @Override
        public String getContenuto() {
            return message.getContenuto().toUpperCase();
        }
    }

    static class LowerMessage extends MessageDecorator {
        public LowerMessage(Message message) { super(message); }

        @Override
        public String getContenuto() {
            return message.getContenuto().toLowerCase();
        }
    }
}