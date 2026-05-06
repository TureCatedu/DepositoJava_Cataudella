package EsercizioComputerFullPattern;

// strategy
interface BootStrategy {

    void bootSequence(Bios b, HardDisk hd, SistemaOperativo os);
}

class NormalBoot implements BootStrategy {

    @Override
    public void bootSequence(Bios b, HardDisk hd, SistemaOperativo os) {
        b.inizializza();
        hd.carica();
        os.avvia();
    }
}

class SafeModeBoot implements BootStrategy {

    @Override
    public void bootSequence(Bios b, HardDisk hd, SistemaOperativo os) {
        System.out.println("[Safe Mode] Saltando controlli superflui...");
        b.inizializza();
        os.avvia(); 
    }
}

class Bios {

    void inizializza() {
        System.out.println("BIOS: Check hardware... OK.");
    }
}

class HardDisk {

    void carica() {
        System.out.println("HardDisk: Caricamento dati in corso...");
    }
}

class SistemaOperativo {

    void avvia() {
        System.out.println("OS: Sistema avviato correttamente.");
    }
}

// facade
class ComputerFacade {

    private final Bios bios = new Bios();
    private final HardDisk hd = new HardDisk();
    private final SistemaOperativo os = new SistemaOperativo();
    private BootStrategy strategy;

    public void setBootStrategy(BootStrategy strategy) {
        this.strategy = strategy;
    }

    public void accendiComputer() {
        strategy.bootSequence(bios, hd, os);
    }
}
