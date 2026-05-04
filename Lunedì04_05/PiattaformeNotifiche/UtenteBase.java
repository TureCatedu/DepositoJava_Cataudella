package PiattaformeNotifiche;

public class UtenteBase extends Observer {
    private final String nome;

    public UtenteBase(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(String messaggio) {
        System.out.println(nome + " riceve: " + messaggio);
    }

    String getNome(){return this.nome;}
}