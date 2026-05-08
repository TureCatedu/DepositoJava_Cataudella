public class Ticket {
    private String id;
    private String title;
    private String description;
    private String status;
    private String ownerId;

    public Ticket(String id, String title, String description, String ownerId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = "OPEN";
        this.ownerId = ownerId;
    }

    public String getId() { return id; }
    public String getOwnerId() { return ownerId; }
    public String getStatus() { return status; }
    
    public void setDescription(String description) { this.description = description; }
    public void setStatus(String status) { this.status = status; }

    // Override del metodo toString per una rappresentazione leggibile del ticket, utile per la visualizzazione nella view
    @Override
    public String toString() {
        return String.format("[Ticket %s] %s | Stato: %s | Creato da: %s | Desc: %s", 
                id, title, status, ownerId, description);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}