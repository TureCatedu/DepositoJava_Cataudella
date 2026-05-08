import java.util.ArrayList;
import java.util.List;

public class Singleton {

    // Il Singleton funge da "database" in memoria per utenti e ticket, 
    // garantendo che tutte le parti del sistema accedano alla stessa istanza condivisa.

    private static Singleton instance;
    private List<Ticket> tickets;
    private List<User> users;

    private Singleton() {
        this.tickets = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Metodi per gestire i ticket e gli utenti, con operazioni di base come aggiunta, rimozione e ricerca.
    public void addTicket(Ticket t) { tickets.add(t); }
    public void removeTicket(Ticket t) { tickets.remove(t); }
    public List<Ticket> getAllTickets() { return tickets; }
    public Ticket getTicketById(String id) {
        for (Ticket t : tickets) {
            if (t.getId().equals(id)) return t;
        }
        return null;
    }


    // Metodi per gestire gli utenti, inclusa la ricerca per username, che è fondamentale per l'autenticazione 
    // e l'associazione dei ticket agli utenti.
    public void addUser(User u) { users.add(u); }
    public User getUserByUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) return u;
        }
        return null;
    }
    public int getUserCount() { return users.size(); }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}