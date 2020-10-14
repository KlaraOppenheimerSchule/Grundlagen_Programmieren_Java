/**
 * Übungen
 */
import java.util.Scanner;

public class Übungen {
    private int number;
    private int faktorialNumber;

    public int getNumber(){
        return number;
    }

    public int getFaktorialNumber(){
        return faktorialNumber;
    }

    public void fnSetNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number: ");
        number = Integer.parseInt(scanner.nextLine());
        scanner.close();
        faktorialNumber = fnFak(number);
    }

    public int fnFak(int num){
        if(num < 2)
            return 1;
        else{
            return (num * fnFak(num-1));
        }
    }

    public static void main(String[] args){
        Übungen newÜbung = new Übungen();
        newÜbung.fnSetNumber();
        System.out.println(newÜbung.getFaktorialNumber());
    }
    
}