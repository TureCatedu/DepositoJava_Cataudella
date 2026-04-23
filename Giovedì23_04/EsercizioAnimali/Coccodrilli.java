package EsercizioAnimali;

public class Coccodrilli extends Animale {
    public Coccodrilli(String nome, int eta) {
        super(nome, eta);
    }

    @Override
    public void faiVerso() {
        System.out.println("Il coccodrillo come fa? Boooo!!");
    }
}
