public abstract class User {
    // La classe User è astratta e funge da base per i diversi tipi di utenti (AdminUser e RegularUser).
    protected String id;
    protected String username;
    protected String password;

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    
    public abstract String getRole();
}