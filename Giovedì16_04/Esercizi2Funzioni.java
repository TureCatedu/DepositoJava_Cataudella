import java.util.Arrays;

public class Esercizi2Funzioni {
    public static void main(String[] args) {
        int x = 15;
        int[] array = {1,2,3,4,5};
        System.out.println(first_natural_recursive(5));
        System.out.println(sum(2,4));
        System.out.println(mult(5,7));
        System.out.println(mult(3.4,5.6,4.2));
        System.out.println(first_natural_recursive(5));
        System.out.println(mod_var(x));
        System.out.println(Arrays.toString(mod_arr(array)));

    }
    public static int sum(int a, int b)
    {
        return a+b;
    }

    public static int mult(int a, int b)
    {
        return a*b;
    }
    public static double mult(double a, double b, double c)
    {
        return a*b*c;
    }
    public static int first_natural_recursive(int a) {
        if (a <= 1) {
            return a;
        } 
        else {
            return a + first_natural_recursive(a - 1);
        }
    }
    public static int mod_var(int x)
    {
        return 5 + x;
    }
    public static int[] mod_arr(int[] arr)
    {
        arr[2] = 30;
        return arr;
    }
}
