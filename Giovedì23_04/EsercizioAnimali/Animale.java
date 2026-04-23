package EsercizioAnimali;

public class Animale {
    protected String nome;
    protected int eta;

    public Animale(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public void faiVerso() {
        System.out.println("Verso generico...");
    }

    public void info() {
        System.out.print("Nome: " + nome + ", Età: " + eta + " - Verso: ");
        faiVerso();
    }
}
