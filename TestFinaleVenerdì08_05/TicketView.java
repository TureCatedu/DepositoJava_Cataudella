import java.util.List;

public class TicketView {
    
    // Metodo per visualizzare una lista di ticket, con un contesto informativo (es. "Vista Admin" o "I tuoi ticket" presente nella viewTickets del controller)
    public void displayTickets(List<Ticket> tickets, String contextInfo) {
        System.out.println("--- Elenco Ticket (" + contextInfo + ") ---");
        if (tickets.isEmpty()) {
            System.out.println("Nessun ticket presente.");
        } else {
            for (Ticket t : tickets) {
                System.out.println(t.toString());
            }
        }
        System.out.println("----------------------------------------");
    }

    public void displaySuccess(String message) {
        System.out.println("SUCCESSO: " + message);
    }

    public void displayError(String error) {
        System.out.println("ERRORE: " + error);
    }
}