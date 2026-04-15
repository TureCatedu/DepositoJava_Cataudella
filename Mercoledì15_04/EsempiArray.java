
public class EsempiArray {

    public static void main(String[] args) {
        {
            //dichiarazione indiretta, array dimensione 5
            int[] numeri = new int[5];

            //dichiarazione diretta
            int[] valori = {1, 2, 3, 4, 5}; //best practice riempire anche di 0 un array anziché inizializzarlo in maniera indiretta

            for (int i : valori) // "i" prende il valore del numero presente nell'array
            {
                System.out.println(valori[i - 1]);          //vale lo stesso
                System.out.println(i);
            }

            //array multidimensionale
            int[][] multi = new int[5][5];
            int[][] matrice = {{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}};

        }
    }
}
