import java.util.ArrayList;             // libreria necessaria per ArrayList

// la dimensione è variabile, fa parte di java collections (java util). ArrayList è un oggetto.
// si usa .size() non length

// un ArrayList si può convertire in array e viceversa (a meno che l'array non sia final)
// un ArrayList non può essere final (obv)

public class EsempiArrayList
{
    public static void main(String[] args)
    {

        ArrayList<Integer> numeri = new ArrayList<>();

        numeri.add(10);
        numeri.add(20);
        numeri.add(30);
        
    }
}