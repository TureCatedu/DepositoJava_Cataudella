import java.util.Scanner;

public class EsercizioArray {

    public static void main(String[] args) {
        //array riguardo ordine e pasticceria 
        String[] menu = {"Torta", "Muffin", "Ciambella"};
        int[] prezzo = {5, 3, 2};

        String[] ordine = new String[3];
        int[] q_ordine = new int[3];

        //scanner
        int input_int;
        String input_string;
        Scanner scan_int = new Scanner(System.in);
        Scanner scan_string = new Scanner(System.in);

        //supporto booleano per ciclo booleano
        boolean again = true;

        //do-while intero programma
        do {
            int quantita;

            //stampa del menu
            System.out.println("Il menù prevede: \n");
            for (int i = 0; i<3; i++) {
            System.out.println(menu[i] + " " + prezzo[i] + "$");  
            }
            System.out.println("\nQuanti dolci vuoi ordinare? (10 max)");
            quantita = scan_int.nextInt();
            if (quantita > 0 && quantita <= 10) {
                //variabile appoggio
                int p = 0;
                do {
                    System.out.println("\nQuale dolce del menù vuoi ordinare?");
                    input_string = scan_string.nextLine();
                    //controllo che il dolce sia presente nell'ordine (so che potrei farlo in maniera diversa ad esempio ciclo for :) ma al momento utilizzo questo)
                    if(input_string.equalsIgnoreCase("torta") || input_string.equalsIgnoreCase("muffin") || input_string.equalsIgnoreCase("ciambella"))
                    {
                        System.out.println("\nIl dolce " + input_string + " è disponibile, la tua quantità disponibile è di " + quantita + ".\nQuante/i " + input_string + " vuoi ordinare?");
                        input_int = scan_int.nextInt();

                        // 3 casi: input rientra nella quanita ordinabile, input supera la quantita ordinabile, input non valido.
                        if(input_int <= quantita && input_int > 0)
                        {
                            System.out.println("\nSono state/i aggiunte/i " + input_int + " " + input_string + " al tuo ordine.");
                            ordine[p] = input_string;
                            q_ordine[p] += input_int;
                            quantita -= input_int;
                            p+=1;
                            if(quantita == 0)
                            {
                                System.out.println("\nQuantità disponibile pari a 0. Ordine completato");
                                again = false;
                                System.out.println("\nIl tuo ordine finale comprende: ");
                            for(int i = 0; i < 3; i++ )
                            {
                                if(ordine[i] == null) break;
                                System.out.println(q_ordine[i] + " " + ordine[i]);
                            }
                            }
                        }
                        else if(quantita > 0 && input_int > quantita)
                        {
                            System.out.println("\nHai ancora " + quantita + " dolci ordinabili. " + input_int + " è > di " + quantita + ".\nRiprova.");
                        }
                        else
                        {
                            System.out.println("\nInput non valido. Riprova.\n");
                        }
                    }
                    else
                    {
                        System.out.println("Dolce non presente nel menù, riprova.");
                        again = true;
                        for (String i : menu) {
                            System.out.println(i);
                        }
                    }
                } while (again);

            } else {
                System.out.println("\nLa quantità non rispetta il range 0 < x <= 10");
            }
            System.out.println("Vuoi uscire dal programma? (s/n) ");
            input_string = scan_string.nextLine();

            if (input_string.equalsIgnoreCase("n")) {
                System.out.println("Restart del programma e dell'ordine.");
                //chiamata ricorsiva del main per forzare restart di tutte le variabili e array.
                main(args);
            }
            else
            {
                again = false;
            }   
    } while (again == true);

}
}