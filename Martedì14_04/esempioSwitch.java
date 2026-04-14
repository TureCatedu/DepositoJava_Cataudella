public class esempioSwitch {
    
    public static void main(String[] args)
    {
        int day = 3;
        switch(day)
        {
            case 1:                 // i casi ammettono solo numeri
                System.out.println("Lunedì");
                break;              // permette di evitare la verifica degli altri casi una volta entrati nel medesimo
            case 2:
                System.out.println("Martedì");
                break;
            case 3:
                System.out.println("Mercoledì");
                break;
        }
    }
}
