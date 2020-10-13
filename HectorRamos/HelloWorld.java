/**
 * HelloWorld
 */
import java.util.Scanner;

public class HelloWorld {
    public int number;
    public int faktorialNumber;

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
            int product;
            product = num * fnFak(num-1);
            return product;
        }
    }

    public static void main(String[] args){
        HelloWorld newWorld = new HelloWorld();
        newWorld.fnSetNumber();
        System.out.println(newWorld.getFaktorialNumber());
    }
    
}