import java.util.ArrayList;

public class EsercizioAerei {
    public static void main(String[] args) {
            CompagniaAerea compagnia = new CompagniaAerea("ITA Airways");
    
            Aereo a1 = new Aereo("Boeing 747", 416, "B747-001");
            Aereo a2 = new Aereo("Airbus A320", 150, "A320-099");
    
            Pilota p1 = new Pilota("Mario Rossi", "BR12345", 1500);
            Pilota p2 = new Pilota("Luigi Bianchi", "BR67890", 2800);
    
            compagnia.aggiungiAereo(a1);
            compagnia.aggiungiAereo(a2);
            compagnia.aggiungiPilota(p1);
            compagnia.aggiungiPilota(p2);
    
            compagnia.stampaInfo();
        }
    }

class Aereo {
    private String modello;
    private int numeroPosti;
    private String codice;

    public Aereo(String modello, int numeroPosti, String codice) {
        this.modello = modello;
        setNumeroPosti(numeroPosti);
        this.codice = codice;
    }

    public String getModello() { return modello; }
    public void setModello(String modello) { this.modello = modello; }

    public int getNumeroPosti() { return numeroPosti; }
    public void setNumeroPosti(int numeroPosti) {
        if (numeroPosti > 0) {
            this.numeroPosti = numeroPosti;
        } else {
            System.out.println("Errore: Il numero di posti deve essere positivo.");
        }
    }

    public String getCodice() { return codice; }
    public void setCodice(String codice) { this.codice = codice; }

    @Override
    public String toString() {
        return "Aereo [Modello: " + modello + ", Posti: " + numeroPosti + ", Codice: " + codice + "]";
    }
}

class Pilota {
    private String nome;
    private String numeroBrevetto;
    private int oreVolo;

    public Pilota(String nome, String numeroBrevetto, int oreVolo) {
        this.nome = nome;
        this.numeroBrevetto = numeroBrevetto;
        setOreVolo(oreVolo);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getNumeroBrevetto() { return numeroBrevetto; }
    public void setNumeroBrevetto(String numeroBrevetto) { this.numeroBrevetto = numeroBrevetto; }

    public int getOreVolo() { return oreVolo; }
    public void setOreVolo(int oreVolo) {
        if (oreVolo > 0) {
            this.oreVolo = oreVolo;
        } else {
            System.out.println("Errore: Le ore di volo devono essere maggiori di zero.");
        }
    }

    @Override
    public String toString() {
        return "Pilota [Nome: " + nome + ", Brevetto: " + numeroBrevetto + ", Ore: " + oreVolo + "]";
    }
}

class CompagniaAerea {
    private String nome;
    private ArrayList<Aereo> flotta;
    private ArrayList<Pilota> piloti;

    public CompagniaAerea(String nome) {
        this.nome = nome;
        this.flotta = new ArrayList<>();
        this.piloti = new ArrayList<>();
    }

    public void aggiungiAereo(Aereo a) {
        flotta.add(a);
    }

    public void aggiungiPilota(Pilota p) {
        piloti.add(p);
    }

    public void stampaInfo() {
        System.out.println("=== Compagnia Aerea: " + nome + " ===");
        System.out.println("--- Flotta ---");
        for (Aereo a : flotta) {
            System.out.println(a);
        }
        System.out.println("--- Piloti ---");
        for (Pilota p : piloti) {
            System.out.println(p);
        }
    }
}