import java.util.ArrayList;

public class Esercizio1Classi {
    static void main(String[] args) {
        
        Libro l = new Libro();
        Libro l1 = new Libro("Giovani", "Giovanni", 29.99 );
        Libro l2 = new Libro("Alberi", "Alberto", 13.99);

        ArrayList<Libro> biblioteca = new ArrayList<>();

        biblioteca.add(l);
        biblioteca.add(l1);
        biblioteca.add(l2);


        for(Libro i : biblioteca)
        {
            i.printLibro();
        }
    }
}

class Libro
{
    String titolo, autore;
    double prezzo;
    int id_libro;

    static int contatore = 0;

    //costruttore default
    Libro(){};

    public Libro(String titolo, String autore, double prezzo) {
        this.titolo = titolo;
        this.autore = autore;
        this.prezzo = prezzo;
        this.id_libro = contatore+=1;
    }

    void printLibro()
    {
        System.err.println("\nTitolo: " + titolo + " - Autore: " + autore + " - Prezzo: " + prezzo + " - codice univoco: " + id_libro);
    }
    
    
}
