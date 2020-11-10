//import com.klara.Core.*;

import java.util.Scanner;
public class App {

    private float liter;
    private float kostenPerLiter;
    private String sorte;
    private Scanner s;

    private final float maxLiter = 100.0f;
    public App(){
        s = new Scanner(System.in);
    }
    
    public void runKosten(){
        System.out.println("Bitte Schreiben Sie die getankte Sorte");
        this.sorte = s.nextLine();
        System.out.println("Bitte Schreiben Sie wie viel Liter");
        this.liter = Float.parseFloat(s.nextLine());
        System.out.println("Bitte Schreiben Sie den Preis von Liter");
        this.kostenPerLiter = Float.parseFloat(s.nextLine());
        s.close();
        if(this.liter>= maxLiter){
            System.out.println("Prima, Rabbat!");
            this.kostenPerLiter*=0.95;
        }
        float total = this.liter*this.kostenPerLiter;
        System.out.println("Total"+total);
      }
    public static void main(String[] args) throws Exception {
        App myApp = new App();
        myApp.runKosten();
        

        //Core.getInstance().runKosten();
    }
}
