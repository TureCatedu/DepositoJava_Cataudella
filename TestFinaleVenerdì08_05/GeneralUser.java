public class GeneralUser extends User {
    // La classe GeneralUser estende User e rappresenta un utente con privilegi standard
    public GeneralUser(String id, String username, String password) {
        super(id, username, password);
    }

    @Override
    public String getRole() { return "General_User"; }
}