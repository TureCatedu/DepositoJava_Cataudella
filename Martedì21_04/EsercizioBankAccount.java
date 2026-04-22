import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioBankAccount {

    static Scanner scanner_int = new Scanner(System.in);
    static Scanner scanner_string = new Scanner(System.in);

    static ArrayList<User> accounts = new ArrayList<>();
    static User loggedAccount;
    static String name;
    static String pass;
    static int scelta;
    static boolean log = false;
    public static void main(String[] args) {

        do {
            if (!log) {
                //menu per utente non loggato
                System.out.println("\nScegli l'azione da eseguire: ");
                System.out.println("1 - Crea account. ");
                System.out.println("2 - Accedi al tuo account. ");
                System.out.println("0 - Esci.");
                scelta = scanner_int.nextInt();

                switch (scelta) {
                    case 1 -> regUser();
                    case 2 -> login();
                    case 0 -> System.out.println("\nProgramma in chiusura...");
                    default -> System.err.println("\nInserimento non valido.");
                }
            }
                else
            {
                //menu per utente loggato
                System.out.println("\nScegli l'azione da eseguire: ");
                System.out.println("1 - Effettua un deposito.");
                System.out.println("2 - Effettua un prelievo.");
                System.err.println("3 - Vedi il tuo bilancio.");
                System.out.println("0 - Esci.");

                scelta = scanner_int.nextInt();

                switch (scelta) {
                    case 1 -> deposit(loggedAccount);
                    case 2 -> withdraw(loggedAccount);
                    case 3 -> loggedAccount.toString();
                    case 0 -> System.out.println("\nProgramma in chiusura...");
                    default -> System.err.println("\nInserimento non valido.");
                }
            }
        }while (scelta != 0);
    }

    public static void regUser() {
        System.out.println("Scrivi il tuo nome utente: ");
        name = scanner_string.nextLine();
        if(valid(name))
        {   
            System.out.println("Nome utente disponibile! Scegli la tua password: ");
            pass = scanner_string.nextLine();
    
            accounts.add(new User(name, pass));
        }
    }
    public static boolean valid(String name)
    {
        boolean isValid = true;
        for (User u : accounts) {
            if (u.accountHolder.equalsIgnoreCase(name)) {
                System.out.println("Nome utente già esistente, utilizzane un altro.");
                isValid = false;
            }
        }
        return isValid;
    }
    public static void login() {
        int tent = 4; //tentativi accesso 
        System.out.println("Digita il tuo nome utente: ");
        name = scanner_string.nextLine();
        while (tent!= 0) {
            for (User u : accounts) {
                if (u.accountHolder.equals(name)) {
                    System.out.println("Digita la tua password: ");
                    pass = scanner_string.nextLine();
                    if (u.password.equals(pass)) {
                        System.out.println("Password corretta! Accesso eseguito correttamente.");
                        loggedAccount = u;
                        log = true;
                        tent = 0;
                    }
                    else
                    {
                        System.out.println("Password errata. " + tent + " tentativi rimanenti, dopodiché la sessione termina.");
                        tent -= 1;
                    }
                }
                else
                {
                    System.out.println("Nome utente non esistente. Riprova.");
                    login();
                }
            }
        }
    }

    public static void deposit(User acc) {
        System.out.println("Quanto vuoi depositare?");
        double amount = scanner_int.nextDouble();
        if (amount > 0) {
        } else {
            System.err.println("Importo <= 0. Deposito necessario >= 0. Riprova");
            deposit(acc);
        }
        acc.balance+=amount;
        System.out.println("\nDeposito effettuato, bilancio aggiornato! Bilancio attuale: " + acc.balance + ".");
    }

    public static void withdraw(User acc) {
        System.out.println("Quanto vuoi prelevare?");
        double amount = scanner_int.nextDouble();
        if (amount > 0 && acc.balance > amount) {
            acc.balance -= amount;
            System.out.println("\nPrelievo effettuato, bilancio aggiornato! Bilancio attuale: " + acc.balance + ".");
        } else {
            System.err.println("Importo <= 0 o bilancio disponibile non sufficiente. Riprova.");
            withdraw(acc);
        }
        
}
}
class User {

    String accountHolder;
    double balance;
    String password;

    User() {
    }

    ;
    User(String accountHolder, String password) {
        this.accountHolder = accountHolder;
        this.password = password;
        balance = 0;
    }

    @Override
    public String toString() {
        return "Nome utente: " + accountHolder + " - " + "Bilancio: " + balance;
    }
}