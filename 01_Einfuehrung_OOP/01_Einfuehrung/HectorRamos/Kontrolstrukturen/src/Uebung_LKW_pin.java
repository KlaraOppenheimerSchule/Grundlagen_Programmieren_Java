import java.util.Random;
import java.util.Scanner;

public class pin {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Anzahl der PINS");
        int anzahl = Integer.parseInt(s.nextLine());
        
        int j = 0;
        String pin = "";
        while(j<anzahl){
            pin = pin + r.nextInt(9);
            
            
        }
    }
}
