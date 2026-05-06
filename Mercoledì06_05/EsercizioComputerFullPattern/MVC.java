package EsercizioComputerFullPattern;

// view
class ComputerView {
    public void mostraMessaggio(String msg) {
        System.out.println("\n[SCHERMO]: " + msg);
    }
}

// controller
class ComputerController {
    private ComputerFacade model;
    private ComputerView view;

    public ComputerController(ComputerFacade model, ComputerView view) {
        this.model = model;
        this.view = view;
    }

    public void avvioNormale() {
        view.mostraMessaggio("Inizializzazione Avvio Standard...");
        model.setBootStrategy(new NormalBoot());
        model.accendiComputer();
    }

    public void avvioProvvisorio() {
        view.mostraMessaggio("Inizializzazione Modalità Provvisoria...");
        model.setBootStrategy(new SafeModeBoot());
        model.accendiComputer();
    }

    public ComputerFacade getModel() {
        return model;
    }

    public void setModel(ComputerFacade model) {
        this.model = model;
    }

    public ComputerView getView() {
        return view;
    }

    public void setView(ComputerView view) {
        this.view = view;
    }
}