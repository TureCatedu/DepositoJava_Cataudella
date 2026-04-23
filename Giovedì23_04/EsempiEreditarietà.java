/*
Una clsse eredita attributi/metodi da una superclasse.
Super classe (classe padre/genitore) e classe derivata o sottoclasse (clsse figlia)

superclasse -> sottoclasse

private -> non vengono ereditati
protected -> protected
public -> public


super() è un costruttore che richiama il costruttore della superclasse e viene utilizzato all'interno del costruttore della sottoclasse

*/

public class EsempiEreditarietà 
{
    public static void main(String[] args)
    {
        Car myCar = new Car("ford", "500");
        Car myCar2 = new Car("maserati", "ghibli");

        
        System.out.println(myCar.brand + " " + myCar.getModel());
        myCar.honk();
        myCar2.honk();

    }
}

class Vehicole
{
    protected String brand = "ford";

    public Vehicole(String brand) {
        this.brand = brand;
    }

    
    public void honk()
    {
        System.out.println("tutu!");
    }
}

class Car extends Vehicole
    {
        final String modelName;
        
        Car(String brand, String modelName)
        {
            super(brand);
            this.modelName = modelName;
        }

        @Override
        public void honk()
        {
            super.honk();
            System.out.println("Clacson macchina " + modelName);
        }
        String getModel(){return modelName;}
    }