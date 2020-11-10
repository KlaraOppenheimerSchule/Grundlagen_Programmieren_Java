/*package com.klara.Core;
import java.util.Scanner;



public class Core {
    private static final Core OBJ = new Core();
    private float liter;
    private float kostenPerLiter;
    private String sorte;

    private int punkte;

    private final float maxLiter = 100.0f;
    private Scanner s;
      private Core() {
          System.out.println("Objekt gebildet...");
          s = new Scanner(System.in);
      }
          
      public static Core getInstance() {
        return OBJ;
      }
      public void runKosten(){
        System.out.println("Bitte Schreiben Sie die getankte Sorte");
        this.sorte = s.nextLine();
        System.out.println("Bitte Schreiben Sie wie viel Liter");
        this.liter = Float.parseFloat(s.nextLine());
        System.out.println("Bitte Schreiben Sie den Preis von Liter");
        this.kostenPerLiter = Float.parseFloat(s.nextLine());
        s.close();
        if(this.liter>= maxLiter)
            System.out.println("Prima!, Rabbat von"+this.sorte);
      }

      public void runIHKpunkte(){
        System.out.println("Bitte Schreiben Sie die Punkte");
        this.punkte = Integer.parseInt(s.nextLine());
        if(this.punkte < 0 || this.punkte > 100)
            System.out.println("Fehler");
        //switch
      }

}*/
