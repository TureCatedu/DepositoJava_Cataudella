public class EserciziFunzioni {
    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(factorial("Ciao"));
    }
    public static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }
    public static String factorial(String err)
    {
        return "\nInserire un numero valido.\n";
    }
}
