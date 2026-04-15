
import java.util.Scanner;

public class EsercizioCicli {

    public static void main(String[] args) {
        {
            int tent = 0;
            String password = "java123";
            Scanner myObj_String = new Scanner(System.in);
            boolean isVerified = false;
            System.out.println("Inserisci la password: ");
            String input;

            do {
                input = myObj_String.nextLine();
                if (input.equalsIgnoreCase(password)) {
                    System.err.println("Utente verificato!");
                    isVerified = true;
                    tent = 10;
                }
                else{
                    System.err.println("Password sbagliata, ritenta. Tentativo numero: " + (tent+1) + ".");
                }
                tent += 1;
            } while (tent < 3);

            if(isVerified)
            {
                do { 
                    System.out.println("Vuoi accedere al sistema? (s/n)");
                    input = myObj_String.nextLine();
                    switch(input)
                    {
                        case "s" -> System.out.println("Accesso al sistema effettuato.");
                                
                        case "n" -> System.out.println("Accesso annullato.");

                        default -> {
                        }
    
                    } 
                } while (!(input.equalsIgnoreCase("s") || input.equalsIgnoreCase("n")));
            }

            else{
                System.out.println("Accesso bloccato");
            }

        }
    }

}
