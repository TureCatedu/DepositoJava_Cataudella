// type variableName = value;

public class Variabili
{
    public static void main(String[] args)
    {
        // i cicli for solo perché non sopporto che sia tutto attaccato nel terminale
        for(int i = 0; i<5; i++)
        {
            System.out.println();
        }

        // dichiarazione variabile senza contenuto
        String testo1;
        testo1 = "prova1";

        // final -> const. dichiarazione costante
        final String c_testo2 = " prova2";

        // il più nella stampa concatena le stringhe
        System.out.println(testo1 + c_testo2);

        // quando dichiaro float e double devo specificare alla fine f e d
        float provaFloat = 13.55f;
        double provaDouble = 12.32d;

        System.out.println(provaFloat + provaDouble);

        for(int i = 0; i<5; i++)
            {
                System.out.println();
            }
    }

}

