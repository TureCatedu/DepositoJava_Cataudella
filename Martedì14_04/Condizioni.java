import java.util.Scanner;

public class Condizioni
{
    public static void main(String[] args)
    {
        int userAge;
        boolean ticket, acc, skip;

        Scanner myObj_int = new Scanner(System.in);
        Scanner myObj_boolean = new Scanner(System.in);

        System.out.println("Quanti anni hai?");
        userAge = myObj_int.nextInt();

        System.out.println("Hai un biglietto valido?");
        ticket = myObj_boolean.nextBoolean();
        if(ticket)
            if(userAge < 18)
                {
                    System.out.println("Sei accompagnato da un adulto?");
                    acc = myObj_boolean.nextBoolean();
                    if (acc)
                    {
                        System.err.println("Puoi partire.");
                        System.out.println("Hai la priority?");
                        skip = myObj_boolean.nextBoolean();
                        skipQueue(skip);
                    }
                    else
                    {
                        System.out.println("Essendo un minore devi necessariamente essere accompagnato da un adulto.");
                    }
                }
            else
            {

                System.out.println("Hai la priority?");
                skip = myObj_boolean.nextBoolean();
                skipQueue(skip);
            }
        else
        {
            System.out.println("Non avendo un biglietto valido non puoi partire.");
        }
    
    }
    public static void skipQueue(boolean skip)
        {
            if(skip)
            {
                System.out.println("Puoi procedere verso la corsia priority.");
            }
            else
            {
                System.out.println("Procedi aspettando in fila.");
            }
        }
}