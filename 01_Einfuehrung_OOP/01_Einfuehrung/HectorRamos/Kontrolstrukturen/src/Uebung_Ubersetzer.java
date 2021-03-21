import java.util.HashMap;
import java.util.Scanner;

public class Uebung_Ubersetzer {
    private HashMap<Character,String> tabelle;
    private String originalSatz;
    private String newSatz;
    private Scanner scan;

    private Uebung_Ubersetzer(){
        tabelle = new HashMap<Character,String>();
        tabelle.put('A',"●➖");
        tabelle.put('B',"➖●●●");
        tabelle.put('C',"➖●➖●");
        tabelle.put('D',"➖➖●");
        tabelle.put('E',"●");
        tabelle.put('F',"●●➖●");
        tabelle.put('G',"➖➖●");
        tabelle.put('H',"●●●●");
        tabelle.put('I',"●●");
        tabelle.put('J',"●➖➖➖");
        tabelle.put('K',"➖●➖");
        tabelle.put('L',"●➖●●");
        tabelle.put('M',"➖➖");
        tabelle.put('N',"➖●");
        tabelle.put('O',"➖➖➖");
        tabelle.put('P',"●➖➖●");
        tabelle.put('Q',"➖➖●➖");
        tabelle.put('R',"●➖●");
        tabelle.put('S',"●●●");
        tabelle.put('T',"➖");
        tabelle.put('U',"●●➖");
        tabelle.put('V',"●●●➖");
        tabelle.put('W',"●➖➖");
        tabelle.put('X',"➖●●➖");
        tabelle.put('Y',"➖●➖➖");
        tabelle.put('Z',"➖➖●●");
/*
        tabelle.put('1',"➖●➖●");
        tabelle.put('2',"➖➖●");
        tabelle.put('3',"➖➖●");
        tabelle.put('4',"●➖");
        tabelle.put('5',"➖●●●");
        tabelle.put('6',"➖●➖●");
        tabelle.put('7',"➖➖●");
        tabelle.put('8',"●➖");
        tabelle.put('9',"➖●●●");*/

        tabelle.put(' '," ");

        scan = new Scanner(System.in);
    }
    public void readSatz(){
        System.out.println("Satz");
        originalSatz = scan.nextLine();
        originalSatz = originalSatz.toUpperCase();
    }
    public void translateSatz(){
        //trim the string
        String[] single = this.originalSatz.split(" ");
        for (String s : single) {
            for(int i=0; i<s.length();i++){
                char ch = s.charAt(i);
                if(this.tabelle.containsKey(ch)){
                    System.out.print(this.tabelle.get(ch));
                }
              }
        }
    }

    public static void main(String[] args) {
        Uebung_Ubersetzer morse = new Uebung_Ubersetzer();
        morse.readSatz();
        morse.translateSatz();
        
    }
}
