public class AdminUser extends User {
    // La classe AdminUser estende User e rappresenta un utente con privilegi amministrativi,
    public AdminUser(String id, String username, String password) {
        super(id, username, password);
    }

    @Override
    public String getRole() { return "Admin_USER"; }
}