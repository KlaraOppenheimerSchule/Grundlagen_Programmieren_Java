//import com.klara.Core.*;

import java.util.Scanner;
public class Uebung_Tankstelle_HectorRamos {

    private float liter;
    private float kostenPerLiter;
    private Scanner s;

    private final float maxLiter = 100.0f;
    private final float dieselK = 0.97f;
    private final float supreE5k = 1.18f;
    private final float superE10k = 1.13f;

    private final String[] BenzinPreise = {"Diesel","SuperE5","SuperE10"};

    public Uebung_Tankstelle_HectorRamos(){
        s = new Scanner(System.in);
    }
    
    public void runKosten(){
        System.out.println("Wahlen Sie die Sorte");
        for(int i=0;i<3;i++)
        System.out.println(i+1+")"+BenzinPreise[i]);

        int opt = Integer.parseInt(s.nextLine());
        switch(opt){
            case 1:
                this.kostenPerLiter = dieselK;
            break;
            case 2:
                this.kostenPerLiter = supreE5k;
            break;
            default:
            this.kostenPerLiter = superE10k;
            break;
        }

        System.out.println("Bitte Schreiben Sie wie viel Liter");
        this.liter = Float.parseFloat(s.nextLine());

       
        if(this.liter>= maxLiter){
            System.out.println("Prima, Rabbat!");
            this.kostenPerLiter*=0.95;
        }
        double total = this.liter*this.kostenPerLiter;
        System.out.println("Total   "+total+" Euro");
        s.close();
      }
    public static void main(String[] args) throws Exception {
        Uebung_Tankstelle_HectorRamos myApp = new Uebung_Tankstelle_HectorRamos();
        myApp.runKosten();
    }
}
