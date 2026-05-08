import java.util.Scanner;

public class Main {

    // Scanner per input da console
    static Scanner scanner = new Scanner(System.in);
    private static User currentUser = null;
    private static int ticketCounter = 1; 

    public static void main(String[] args) {

        // Inizializzazione del sistema con una vista e i controller
        TicketView view = new TicketView();
        AutenticazioneController authController = new AutenticazioneController(view);
        TicketControllerFacade ticketController = new TicketControllerFacade(view);

        boolean running = true;

        System.out.println("======================================");
        System.out.println("       SISTEMA GESTIONE TICKET        ");
        System.out.println("======================================");

        // Loop principale del programma
        while (running) {
            if (currentUser == null) {
        
                System.out.println("\n--- MENU ACCESSO ---");
                System.out.println("1. Login");
                System.out.println("2. Registrati");
                System.out.println("3. Esci");
                System.out.print("Scelta: ");
                
                String choice = scanner.nextLine();

                // Gestione delle scelte per login, registrazione ed uscita
                switch (choice) {
                    case "1" -> {
                        System.out.print("Username: ");
                        String loginUser = scanner.nextLine();
                        System.out.print("Password: ");
                        String loginPass = scanner.nextLine();
                        currentUser = authController.login(loginUser, loginPass);
                    }
                    case "2" -> {
                        System.out.print("Nuovo Username: ");
                        String regUser = scanner.nextLine();
                        System.out.print("Nuova Password: ");
                        String regPass = scanner.nextLine();
                        System.out.print("Sei un Admin? (s/n): ");
                        boolean isAdmin = scanner.nextLine().trim().equalsIgnoreCase("s");
                        authController.register(regUser, regPass, isAdmin);
                    }
                    case "3" -> {
                        running = false;
                        System.out.println("Arrivederci!");
                    }
                    default -> System.out.println("Scelta non valida.");
                }
            } else {
                
                // Menu principale per utenti loggati, con opzioni diverse per Admin e GeneralUser
                System.out.println("\n--- MENU TICKET (" + currentUser.getUsername() + " - " + currentUser.getRole() + ") ---");
                System.out.println("1. Visualizza Ticket");
                System.out.println("2. Crea Nuovo Ticket");
                System.out.println("3. Modifica Ticket (Solo Admin)");
                System.out.println("4. Risolvi Ticket (Solo Admin)");
                System.out.println("5. Elimina Ticket (Solo Admin)");
                System.out.println("6. Logout");
                System.out.print("Scelta: ");

                String choice = scanner.nextLine();

                // Gestione delle scelte per operazioni sui ticket e logout
                switch (choice) {
                    case "1" -> ticketController.viewTickets(currentUser);
                    case "2" -> {
                        System.out.print("Titolo: ");
                        String title = scanner.nextLine();
                        System.out.print("Descrizione: ");
                        String desc = scanner.nextLine();
                        String tId = "T" + ticketCounter++;
                        ticketController.createTicket(currentUser, tId, title, desc);
                    }
                    case "3" -> {
                        System.out.print("ID del Ticket da modificare: ");
                        System.out.println("Tciket presenti: ");
                        ticketController.viewTickets(currentUser);
                        String idMod = scanner.nextLine();
                        System.out.print("Nuova descrizione: ");
                        String newDesc = scanner.nextLine();
                        ticketController.updateTicketDescription(currentUser, idMod, newDesc);
                    }
                    case "4" -> {
                        System.out.print("ID del Ticket da risolvere: ");
                        System.out.println("Tciket presenti: ");
                        ticketController.viewTickets(currentUser);
                        String idRes = scanner.nextLine();
                        ticketController.resolveTicket(currentUser, idRes);
                    }
                    case "5" -> {
                        System.out.print("ID del Ticket da eliminare: ");
                        System.out.println("Tciket presenti: ");
                        ticketController.viewTickets(currentUser);
                        String idDel = scanner.nextLine();
                        ticketController.deleteTicket(currentUser, idDel);
                    }
                    case "6" -> {
                        currentUser = null;
                        System.out.println("Logout effettuato.");
                    }
                    default -> System.out.println("Scelta non valida.");
                }
            }
        }
        scanner.close();
    }
}