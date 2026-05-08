import java.util.ArrayList;
import java.util.List;

public class TicketControllerFacade {
    private Singleton db;
    private TicketView view;

    // Il controller accetta una vista e accede al database tramite il Singleton
    public TicketControllerFacade(TicketView view) {
        this.db = Singleton.getInstance();
        this.view = view;
    }

    // crea un nuovo ticket associato all'utente che lo ha creato
    public void createTicket(User user, String ticketId, String title, String description) {
        Ticket newTicket = new Ticket(ticketId, title, description, user.getId());
        db.addTicket(newTicket);
        view.displaySuccess("Ticket '" + ticketId + "' creato.");
    }
    
    // mostra i ticket: se è un Admin mostra tutti, altrimenti solo quelli dell'utente
    public void viewTickets(User user) {
        List<Ticket> allTickets = db.getAllTickets();
        
        if (user instanceof AdminUser) {
            view.displayTickets(allTickets, "Vista Admin - Tutti i ticket");
        } else {
            List<Ticket> ownTickets = new ArrayList<>();
            for (Ticket t : allTickets) {
                if (t.getOwnerId().equals(user.getId())) {
                    ownTickets.add(t);
                }
            }
            view.displayTickets(ownTickets, "I tuoi ticket - " + user.getUsername());
        }
    }

    // solo gli Admin possono modificare la descrizione di un ticket
    public void updateTicketDescription(User user, String ticketId, String newDescription) {
        if (!(user instanceof AdminUser)) {
            view.displayError("Solo gli Admin possono modificare un ticket.");
            return;
        }
        Ticket t = db.getTicketById(ticketId);
        if (t != null) {
            t.setDescription(newDescription);
            view.displaySuccess("Ticket aggiornato.");
        } else {
            view.displayError("Ticket non trovato.");
        }
    }

    // solo gli Admin possono risolvere un ticket, cambiando il suo stato
    public void resolveTicket(User user, String ticketId) {
        if (!(user instanceof AdminUser)) {
            view.displayError("Solo gli Admin possono risolvere i ticket.");
            return;
        }
        Ticket t = db.getTicketById(ticketId);
        if (t != null) {
            t.setStatus("RESOLVED");
            view.displaySuccess("Ticket risolto.");
        } else {
            view.displayError("Ticket non trovato.");
        }
    }

    // solo gli Admin possono eliminare un ticket
    public void deleteTicket(User user, String ticketId) {
        if (!(user instanceof AdminUser)) {
            view.displayError("Accesso negato! L'utente '" + user.getUsername() + "' non ha i permessi per eliminare il ticket.");
            return;
        }
        Ticket t = db.getTicketById(ticketId);
        if (t != null) {
            db.removeTicket(t);
            view.displaySuccess("Ticket eliminato.");
        } else {
            view.displayError("Ticket non trovato.");
        }
    }

    public Singleton getDb() {
        return db;
    }

    public void setDb(Singleton db) {
        this.db = db;
    }

    public TicketView getView() {
        return view;
    }

    public void setView(TicketView view) {
        this.view = view;
    }
}