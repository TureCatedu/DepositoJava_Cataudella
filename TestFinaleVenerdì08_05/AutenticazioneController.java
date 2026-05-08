public class AutenticazioneController {

    // Il controller per gestire le operazioni di autenticazione (login e registrazione) degli utenti, 
    // interagendo con la vista per mostrare messaggi di successo o errore
    private final Singleton db;
    private final TicketView view;

    public AutenticazioneController(TicketView view) {
        this.db = Singleton.getInstance();
        this.view = view;
    }

    // Il metodo di registrazione verifica se l'username è già presente, 
    // crea un nuovo utente (Admin o General) e lo aggiunge al database, mostrando un messaggio di successo o errore.
    public boolean register(String username, String password, boolean isAdmin) {
        if (db.getUserByUsername(username) != null) {
            view.displayError("Username già esistente. Scegline un altro.");
            return false;
        }

        String newId = "U" + (db.getUserCount() + 1);
        User newUser;

        if (isAdmin) {
            newUser = new AdminUser(newId, username, password);
        } else {
            newUser = new GeneralUser(newId, username, password);
        }

        db.addUser(newUser);
        view.displaySuccess("Utente '" + username + "' registrato con successo come " + newUser.getRole() + "!");
        return true;
    }

    // Il metodo di login verifica se l'utente esiste e se la password è corretta, 
    // restituendo l'utente loggato o null in caso di errore, con messaggi appropriati.
    public User login(String username, String password) {
        User user = db.getUserByUsername(username);
        
        if (user != null && user.getPassword().equals(password)) {
            view.displaySuccess("Benvenuto, " + username + " (" + user.getRole() + ")!");
            return user;
        }
        
        view.displayError("Credenziali non valide. Riprova.");
        return null;
    }
}
