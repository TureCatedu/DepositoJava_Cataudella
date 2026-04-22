/* 

import java.util.ArrayList;


public class EsempiClassi
{
    public static void main(String[] args)
    {
        //si istanzia con nomeClasse nomeOggetto = new nomeCLasse
        Auto miaAuto = new Auto();
        Auto tiguan = new Auto("Volkswagen", 2024, 25000.00);

        //posso utilizzre un ArrayList
        ArrayList<Auto> garage = new ArrayList<>();

        garage.add(miaAuto);
        garage.add(tiguan);

        for(Auto i : garage)
        {
            i.mostraInfo();
        }
    }
}

class NomeClasse
{
    Attributi (variabili)
    tipoDato nomeAttributo;


    metodi (funzioni)
    tipoRitorno nomeMetodo()
        codice
}



    class Auto
{

    String marca;
    int anno;
    double prezzo;

    //attributi legati alla classe e non all'oggetto. non posso utilizzare tiguan.numRuote ma solo dalla classe Auto
    static int numRuote = 4;
    //costruttori, costruttore di default senza variabili e costruttore con attributi
    public Auto() {
    }

    public Auto(String marca, int anno, double prezzo) {
        this.marca = marca;
        this.anno = anno;
        this.prezzo = prezzo;
    }

    
    void mostraInfo()
    {
        System.err.println("\n" + marca + " - " + anno + " - " + prezzo + " - Ruote: " + numRuote);
    }
}
*/
