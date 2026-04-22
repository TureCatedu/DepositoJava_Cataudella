import java.util.ArrayList;
import java.util.Objects;

public class EsercizioAutoOfficina {

    public static void main(String[] args) {

        Officina miaOfficina = new Officina();

        Auto auto1 = new Auto("AA123BB", "Fiat Panda");
        Auto auto2 = new Auto("CC456DD", "Tesla Model 3");
        Auto auto3 = new Auto("EE789FF", "Alfa Romeo Giulia");

        miaOfficina.aggiungiAuto(auto1);
        miaOfficina.aggiungiAuto(auto2);
        miaOfficina.aggiungiAuto(auto3);

        miaOfficina.stampaElenco();
    }
}


class Auto {
    private String targa;
    private String modello;

    public Auto(String targa, String modello) {
        this.targa = targa;
        this.modello = modello;
    }

    @Override
    public String toString() {
        return "Targa: " + targa + ", Modello: " + modello;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(targa, auto.targa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(targa);
    }
}

class Officina {

    private ArrayList<Auto> elencoAuto;

    public Officina() {
        this.elencoAuto = new ArrayList<>();
    }

    public void aggiungiAuto(Auto nuovaAuto) {
        elencoAuto.add(nuovaAuto);
        System.out.println("Auto aggiunta con successo!");
    }

    public void stampaElenco() {
        System.out.println("\n--- ELENCO AUTO IN OFFICINA ---");
        if (elencoAuto.isEmpty()) {
            System.out.println("L'officina è vuota.");
        } else {
            for (Auto a : elencoAuto) {
                System.out.println(a.toString());
            }
        }
        System.out.println("-------------------------------\n");
    }
}
