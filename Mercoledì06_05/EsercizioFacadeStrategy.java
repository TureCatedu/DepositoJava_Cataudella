public class EsercizioFacadeStrategy {
    public static void main(String[] args) {
        Facade facade = new Facade();

        System.out.println("--- Test Modalità Eco ---");
        facade.accendiLuciEco();

        System.out.println("\n--- Test Modalità Full ---");
        facade.accendiLuciFull();
    }
}


class LuceCamera {
    void accendiFull() { System.out.println("Luce Camera: accesa."); }
    void accendiEco() { System.out.println("Luce Camera: accesa al 20%."); }
}

class LuceCucina {
    void accendiFull() { System.out.println("Luce Cucina: accesa."); }
    void accendiEco() { System.out.println("Luce Cucina: accesa al 20%."); }
}

// strategy
interface StrategyLight {
    void esegui(LuceCamera cam, LuceCucina cuc);
}

class ModalitaEco implements StrategyLight {
    @Override
    public void esegui(LuceCamera cam, LuceCucina cuc) {
        cam.accendiEco();
        cuc.accendiEco();
    }
}

class ModalitaFull implements StrategyLight {
    @Override
    public void esegui(LuceCamera cam, LuceCucina cuc) {
        cam.accendiFull();
        cuc.accendiFull();
    }
}

// facade
class Facade {
    private LuceCamera luceCamera = new LuceCamera();
    private LuceCucina luceCucina = new LuceCucina();
    
    public void accendiLuciEco() {
        StrategyLight eco = new ModalitaEco();
        eco.esegui(luceCamera, luceCucina);
    }

    public void accendiLuciFull() {
        StrategyLight full = new ModalitaFull();
        full.esegui(luceCamera, luceCucina);
    }

    public LuceCamera getLuceCamera() {
        return luceCamera;
    }

    public void setLuceCamera(LuceCamera luceCamera) {
        this.luceCamera = luceCamera;
    }

    public LuceCucina getLuceCucina() {
        return luceCucina;
    }

    public void setLuceCucina(LuceCucina luceCucina) {
        this.luceCucina = luceCucina;
    }
}