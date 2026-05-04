package PiattaformeNotifiche;
import java.util.ArrayList;

public class Singleton {
    private static Singleton instance;
    private ArrayList<Observer> utenti = new ArrayList<>();

    private Singleton() {} 

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void iscrivi(Observer utente) {
        utenti.add(utente);
    }

    public void disiscrivi(Observer utente) {
        utenti.remove(utente);
    }

    public void inviaNotifica(String messaggio) {
        for (Observer utente : utenti) {
            utente.update(messaggio);
        }
    }

    ArrayList<Observer> getUtenti(){return this.utenti;}

    public void setUtenti(ArrayList<Observer> utenti) {
        this.utenti = utenti;
    }
}