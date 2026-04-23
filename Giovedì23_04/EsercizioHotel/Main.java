package EsercizioHotel;

public class Main {
    public static void main(String[] args) {

        Hotel mioHotel = new Hotel("Grand Hotel");

        mioHotel.aggiungiCamera(new Camera(101, 80.50f));
        mioHotel.aggiungiCamera(new Camera(102, 85.00f));
        mioHotel.aggiungiCamera(new Suite(501, 250.00f, "Spa privata, Champagne"));
        mioHotel.aggiungiCamera(new Suite(502, 300.00f, "Vista Mare, Maggiordomo"));

        System.out.println("--- Dettagli Camere (Overload) ---");
        for (Camera c : mioHotel.getListaCamere()) {
          
            if (c instanceof Suite) {
                c.dettagli(true); 
            } else {
                c.dettagli(false);
            }
        }

        System.out.println("\n--- Conteggio Suite (Statico) ---");
        int numeroSuite = Hotel.contaSuite(mioHotel.getListaCamere());
        System.out.println("Numero totale di Suite nell'hotel: " + numeroSuite);
    }
}