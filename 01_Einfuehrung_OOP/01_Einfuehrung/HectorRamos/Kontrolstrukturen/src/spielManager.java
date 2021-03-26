import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class spielManager {
    private Scanner s;
        private List<computerSpieler> spielers;

        private boolean gameEnded   = false;
        private int maxLives       = 0;
        private int passivSpieler = 0;
        private int aktivSpieler   = 0;

        public spielManager(){
            this.spielers = new ArrayList<computerSpieler>();
            this.spielers.add(new computerSpieler());
            this.spielers.add(new computerSpieler());
            s = new Scanner(System.in);
        }
        /**
         * erzeug zwei Spielers mit ihrem dementsprechenden Grids und Schiffe
         * @param gridGroße
         * @param totalSchiffe
         * @param lives
         */
        public void createGame (int gridGroße, int totalSchiffe, int lives){
                int counter;
                int i = 0;
                
                if(totalSchiffe<lives)
                    lives = totalSchiffe;
                this.maxLives = lives;
                
                for (computerSpieler cs : this.spielers) {
                    cs.createGrid(gridGroße);
                    cs.setLives(lives);
                    
                    counter = 0;
                    while(counter< totalSchiffe){
                        Random rand = new Random();
                        coordenate2D co = new coordenate2D();
                        
                        co.setX(rand.nextInt(gridGroße));
                        co.setY(rand.nextInt(gridGroße));
                        if(cs.addSchiff(co))
                            counter++;
                    }

                    System.out.println("Spiler´s"+i+" Schiffe:");
                    for (coordenate2D coPo : cs.getSchiffePositionen()) {
                        System.out.println("( "+coPo.getX() + " , "+ coPo.getY()+" )");
                    }
                    i++;
                }
        }
        
        public void start(){
            passivSpieler = 1;
            aktivSpieler   = 0;
            int temp = 0;
            do{
                //der aktive Spieler shieß
                System.out.println("Spieler in Turn:"+aktivSpieler);
                coordenate2D co = this.spielers.get(aktivSpieler).tippen();
                System.out.println("Firing at:"+"( "+co.getX()+" , "+co.getY()+" )");

                //der pasive Spieler überpruft ob ein von seinen Schiff angeschossen wurde
                gameEnded = this.spielers.get(passivSpieler).tippPruefen(co);
                if(gameEnded)
                    System.out.println("Spieler "+aktivSpieler+" gewonnen");
                else{
                //change the order
                    temp = passivSpieler;
                    passivSpieler = aktivSpieler;
                    aktivSpieler = temp;
                }
                //s.nextLine();
            }while(!this.gameEnded);

        }
        public void showScores(){
            System.out.println("Spieler: "+aktivSpieler+" hat gewonnen");
            System.out.println("Final score: Spieler´s "+aktivSpieler+"  Punkte: "+this.maxLives);
            System.out.println("Final score: Spieler´s "+passivSpieler+
                                "  Punkte: "+(this.maxLives-this.spielers.get(aktivSpieler).getLives()) );
        }
}
