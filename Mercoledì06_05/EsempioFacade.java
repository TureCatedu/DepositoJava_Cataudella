
public class EsempioFacade {
// Client

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.operazioneUnificata();
    }
}

// Sottosistema
class SubsystemA {

    void operationA() {
        System.out.println("Operazione A del sottosistema A");
    }
}

class SubsystemB {

    void operationB() {
        System.out.println("Operazione B del sottosistema B");
    }
}

// Facade
class Facade {

    private SubsystemA a = new SubsystemA();
    private SubsystemB b = new SubsystemB();

    public void operazioneUnificata() {
        a.operationA();
        b.operationB();
    }

    public SubsystemA getA() {
        return a;
    }

    public void setA(SubsystemA a) {
        this.a = a;
    }

    public SubsystemB getB() {
        return b;
    }

    public void setB(SubsystemB b) {
        this.b = b;
    }
}
