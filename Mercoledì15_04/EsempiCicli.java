import java.util.Scanner;

public class EsempiCicli
{
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args)
    {
        //while
        System.out.println("\nWhile");
        int p = 0;
        while(p<5)
        {
            System.out.println(p);
            p++;
        }
        
        int input;
        //do-while
        Scanner myObj_int = new Scanner(System.in);
        do { 
            System.out.println("\nDo-while - > Premi 0 per uscire: ");
            input = myObj_int.nextInt();
        } while (input != 0);
        System.out.println("Programma terminato.");


        //for

        System.out.println("Di quale numero vuoi conoscere la tabellina?");
        input = myObj_int.nextInt();

        System.out.println("\nTabellina del numero: " + input + ".\n");
        for (int i = 1; i <= 10; i++)
        {
            System.out.println(input + " x " + i + " = " + (input * i));
        }

        myObj_int.close();
    }
}