public class EsempiFunzioni {
    public static void main(String[] args) {
        //chiamata al metodo
        saluta();
        System.out.println(sum(3,4));
        System.out.println(5);
        System.out.println("Ciao");
    }
    //returnType nome(parametri)
    public static int sum(int a, int b)
    {
        return a + b;
    }
    public static void saluta()
    {
        System.out.println("Ciao, Java!");
    }

    //overloading funzioni, funzione con stesso nome ma con parametri di tipi diversi (viene chiamata quella corretta rispettando i parametri)
    public static void mostra(int numero) {
        System.out.println("Numero: " + (10 + numero));
    }
    public static void mostra(String testo) {
        System.out.println("Testo: " + testo);
    }

    //funzione ricorsiva
    public static int factorial(int n) {
            if (n == 0 || n == 1)
                return 1;
            return n * factorial(n - 1);
        }
}
