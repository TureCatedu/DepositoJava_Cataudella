import java.util.ArrayList;

public class Esercizio2Classi {
    public static void main(String[] args) {
        
    ArrayList<Persona> gente = new ArrayList<>();

    Persona p1 = new Persona("Andrea", 22);
    Persona p2 = new Persona("Roberto", "Grenoble", 23); 
    Persona p3 = new Persona();
    
    gente.add(p1);
    gente.add(p2);
    gente.add(p3);

    for(Persona i : gente)
        {
            i.printPersona();
        }

    }
}

class Persona
{
    String nome, citta;
    int eta;

    Persona(){};

    Persona(String nome, int eta)
    {
        this.nome = nome;
        this.eta = eta;
        this.citta = "Non te lo dico";
    }

    public Persona(String nome, String citta, int eta) {
        this.nome = nome;
        this.citta = citta;
        this.eta = eta;
    }

    public void printPersona()
    {
        System.err.println("\nNome: " + nome + " - Età: " + eta + " - Città: " + citta + ".");
    }
}
