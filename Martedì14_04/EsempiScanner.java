import java.util.Scanner;   //libreria scanner

public class EsempiScanner
{

    public static void main(String[] args)
    {
        Scanner myObj = new Scanner(System.in);  //creazione oggetto scanner
        System.out.println("\nScrivi il tuo nome: ");

        String userName = myObj.nextLine(); // lettura input utente, nextLine legge solo stringhe
        System.out.println("Il nome dell'utente è: " + userName);

        //per accettare int/boolean ecc... in input si utilizzano i metodi specifici myObj.nextBoolean() e via dicendo...
        Scanner myObj_int = new Scanner(System.in);
        System.out.println("\n\nQuanti anni hai: ");
        int userAge = myObj_int.nextInt();
        System.out.println("\nL'utente ha " + userAge + " anni." );

        //confronti
        System.out.println("Quali numeri vuoi conforontare? (inseriscine uno per volta)");
        int x = myObj_int.nextInt();
        System.out.println("Inserisci l'altro");
        int y = myObj_int.nextInt();

        if(x > y)
        {
            System.out.println(x + " è maggiore di " + y);
        }
        else if(x < y)
        {
            System.out.println(y + " è maggiore di " + x);
        }
        else
        {
            System.out.println(x + " è uguale a " + y);
        }
        
        

    }

    
}