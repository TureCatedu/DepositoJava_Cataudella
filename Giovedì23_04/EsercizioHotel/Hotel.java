package EsercizioHotel;
import java.util.ArrayList;

public class Hotel {
    private String nome;
    private ArrayList<Camera> listaCamere;

    public Hotel(String nome) {
        this.nome = nome;
        this.listaCamere = new ArrayList<>();
    }

    public void aggiungiCamera(Camera c) {
        listaCamere.add(c);
    }

    public static int contaSuite(ArrayList<Camera> lista) {
        int contatore = 0;
        for (Camera c : lista) {
            if (c instanceof Suite) { 
                contatore++;
            }
        }
        return contatore;
    }

    public ArrayList<Camera> getListaCamere() {
        return listaCamere;
    }
}