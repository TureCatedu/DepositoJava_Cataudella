package PiattaformeNotifiche;
import java.time.LocalDateTime;

public abstract class NotificaDecorator extends Observer {
    protected Observer utenteDecorato;

    public NotificaDecorator(Observer utente) {
        this.utenteDecorato = utente;
    }

    @Override
    public void update(String messaggio) {
        utenteDecorato.update(messaggio);
    }
}


class UpperCaseDecorator extends NotificaDecorator {
    public UpperCaseDecorator(Observer utente) { super(utente); }

    @Override
    public void update(String messaggio) {
        super.update(messaggio.toUpperCase());
    }
}


class TimestampDecorator extends NotificaDecorator {
    public TimestampDecorator(Observer utente) { super(utente); }

    @Override
    public void update(String messaggio) {
        String data = "[" + LocalDateTime.now().withNano(0) + "] ";
        super.update(data + messaggio);
    }
}