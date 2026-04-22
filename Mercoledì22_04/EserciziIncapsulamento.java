import java.util.ArrayList;
import java.util.Scanner;

public class EserciziIncapsulamento
{

    static Scanner scanner_string = new Scanner(System.in);
    static Scanner scanner_int = new Scanner(System.in);

    static ArrayList<Studente> studentList = new ArrayList<>();
    static int scelta;

    public static void main(String[] args) {
        
        do { 
            System.out.println("\n--------------------------- MENÙ ---------------------------");
            System.out.println("\nScegli l'azione da eseguire: ");
            System.out.println("1 - Aggiungi uno studente al registro.");
            System.out.println("2 - Aggiungi un voto ad uno studente.");
            System.out.println("3 - Rimuovi uno studente dal registro.");
            System.out.println("4 - Cerca uno studente nel registro.");
            System.out.println("0 - Esci dal programma.");
            scelta = scanner_int.nextInt();
            switch(scelta)
            {
                case 1 -> addStudent();
                case 2 -> addVote();
                case 3 -> removeStudent();
                case 4 -> search();
                case 0 -> System.out.println("Programma in chiusura...");
                default -> System.err.println("Scelta non valida.");
            }
        } while (scelta!=0);

    }

    public static void addStudent()
    {
        System.out.println("Scrivi il nome dello studente da aggiungere: ");
        String newName = scanner_string.nextLine();
        System.out.println("Scrivi il cognome dello studente da aggiungere: ");
        String newSurname = scanner_string.nextLine();

        studentList.add(new Studente(newName, newSurname));
    }

    public static void addVote()
    {
        System.out.println("Scrivi il nome dello studente a cui vuoi aggiungere il voto: ");
        String nam = scanner_string.nextLine();
        System.out.println("Scrivi il cognome dello studente a cui vuoi aggiungere il voto: ");
        String sur = scanner_string.nextLine();
        Studente n = searchStudent(new Studente(nam, sur));
        if(n!=null)
        {
            System.out.println("Studente trovato nel registro. Che voto vuoi aggiungere? (Il voto deve essere compreso tra 0 e 10) ");
            int v = scanner_int.nextInt();
            n.setVote(v);
        }
        else
        {
            System.err.println("Studente non trovato! Riprova.");
            addVote();
        }
                    
        
    }

    public static void removeStudent()
    {
        System.out.println("Quale studente vuoi rimuovere? Scrivi il nome: ");
        String nam = scanner_string.nextLine();
        System.out.println("Scrivi il cognome: ");
        String sur = scanner_string.nextLine();
        Studente remStudente = searchStudent(new Studente(nam, sur));
        if(remStudente!= null)
        {
            studentList.remove(remStudente);
            System.out.println("\nStudente rimosso con successo!");
        }
        else
        {
            System.out.println("\nStudente non trovato.");
        }
    }  

    public static void search() //funzione specifica del menù
    {
        System.out.println("Quale studente vuoi cercare? Scrivi il nome: ");
        String nam = scanner_string.nextLine();
        System.out.println("Scrivi il cognome: ");
        String sur = scanner_string.nextLine();
        searchStudent(new Studente(nam, sur));  
    }

    public static Studente searchStudent(Studente _studente) //funzione generale per ricerca Studente
    {
        for(Studente s : studentList)
            {
                if(_studente.getName().equalsIgnoreCase(s.getName()) && _studente.getSurname().equalsIgnoreCase(s.getSurname()))
                {
                    System.out.println("Studente trovato: " + s.toString());
                    return s;
                }
            }
        return null;
    }
}

class Studente
{
    private String name;
    private String surname;
    private int vote;
    private static int id;

    private int contatore = 0;
    public Studente() {
    }

    public Studente(String name, String surname) {
        this.name = name;
        this.surname = surname;
        id = contatore+1;
    }

    public Studente(String name, String surname, int vote) {
        this.name = name;
        this.surname = surname;
        this.vote = vote;
        id = contatore+1;
    }

    String getName(){return name;}
    String getSurname(){return surname;}
    int getVote(){return vote;} //non mi è servito ma richiesto (potrebbe servire)

    void setVote(int _vote)
    {
        if(_vote >= 0 && _vote <= 10)
        {
            this.vote = _vote;
            System.out.println("Voto aggiunto/modificato con successo!");
        }
        else{
            System.err.println("Voto non valido. Il voto deve essere compreso tra 0 e 10.");
        }
    }

    @Override
    public String toString()
    {
        return "Alunno: " + name + " - Cognome: " + surname + " - Voto: " + this.vote + " - Codice univoco: " + id + ".";
    }
}