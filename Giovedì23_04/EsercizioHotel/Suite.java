package EsercizioHotel;

public class Suite extends Camera {
    private String serviziExtra;

    public Suite(int numero, float prezzo, String serviziExtra) {
        super(numero, prezzo); 
        this.serviziExtra = serviziExtra;
    }

    public String getServiziExtra() { return serviziExtra; }
    public void setServiziExtra(String serviziExtra) { this.serviziExtra = serviziExtra; }

    @Override
    public void dettagli() {
        System.out.println("SUITE Numero: " + getNumero() + 
                           ", Prezzo: " + getPrezzo() + 
                           "€, Servizi: " + serviziExtra);
    }
}