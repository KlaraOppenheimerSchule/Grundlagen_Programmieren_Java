import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Uebung_Schiffe_Versenken {
    public class coordenate2D{
        private int x;
        private int y;
        public coordenate2D(){
            x = 0; y = 0;
        }
        public void setX(int x) {
            this.x = x;
        }
        public void setY(int y) {
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }

        /***
     * 
     */
    public class spieler{
        private List<coordenate2D> schiffePositionen;
        private List<coordenate2D> visitedPositionen;
        private char[][] grid;
        private int lives;

        public List<coordenate2D> getSchiffePositionen() {
            return schiffePositionen;
        }
        public boolean addSchiff(coordenate2D co){
            if(schiffePositionen.contains(co))
                return false;
            schiffePositionen.add(co);
            return true;
        }

        public void createGrid (int große){
            this.grid = new char[große][große];
            for(int i=0; i<große; i++) 
                for(int j=0; j<große; j++) 
                    this.grid[i][j] = ' ';
        }

        public void showGrid (){
            for (int row = 0; row < this.grid.length; row++) {
                for (int col = 0; col < this.grid[row].length; col++) {
                   System.out.print(this.grid[row][col]);
                }
                System.out.println();
             }
        }

        public spieler(){
            this.schiffePositionen = new ArrayList<coordenate2D>();
            this.visitedPositionen = new ArrayList<coordenate2D>();
        }
        public coordenate2D tippen(){
            Random rand = new Random();
            coordenate2D co = new coordenate2D();
            int int_random;
            do{
                int_random = rand.nextInt(4);
                co.setX(rand.nextInt(4));
                co.setY(rand.nextInt(4));
            }while(this.visitedPositionen.contains(co));
            this.visitedPositionen.add(co);
            return new coordenate2D();
        }
        public boolean tippPruefen(coordenate2D co){
            if(schiffePositionen.contains(co)){
                lives--;
                System.out.print("Impact!!!!");
                this.grid[co.x][co.y] = '*';
                this.showGrid();

                if(lives<1)
                    return true;
            }
            return false;
        }
        
    }
    public class computerSpieler extends spieler{}
    public class menschlicherSpieler extends spieler{}

    /****
     * 
     */
    public class spielManager{
        //private computerSpieler spielerA;
        //private computerSpieler spielerB;
        private Scanner s;
        private List<computerSpieler> spielers;

        private char[][] gridSpielerA;
        private char[][] gridSpielerB;

        private boolean gameEnded   = false;
        private int passiveSpieler = 0;
        private int activSpieler   = 0;

        public spielManager(){
            spielers = new ArrayList<computerSpieler>();
            spielers.add(new computerSpieler());
            spielers.add(new computerSpieler());
            Scanner s = new Scanner(System.in);
        }
        
        public void loadData (int gridGroße, int totalSchiffe){
                int counter;
                
                
                for (computerSpieler cs : this.spielers) {
                    cs.createGrid(gridGroße);
                    
                    counter = 0;
                    while(counter< totalSchiffe){
                        Random rand = new Random();
                        coordenate2D co = new coordenate2D();
                        int int_random = rand.nextInt(4);
                        co.setX(rand.nextInt(4));
                        co.setY(rand.nextInt(4));
                        if(cs.addSchiff(co))
                            counter++;
                    }

                    int  i = 0;
                    System.out.println("Spiler´s"+i+" Schiffe:");
                    for (coordenate2D coPo : cs.getSchiffePositionen()) {
                        System.out.println("x->"+coPo.x + "y->"+ coPo.y);
                    }
                }
        }
        
        public void start(){
            passiveSpieler = 0;
            activSpieler   = 1;
            int temp = 0;
            while(!this.gameEnded){
                coordenate2D co = this.spielers.get(passiveSpieler).tippen();
                gameEnded = this.spielers.get(passiveSpieler).tippPruefen(co);
                s.nextLine();
                temp = passiveSpieler;
                passiveSpieler = activSpieler;
                activSpieler = passiveSpieler;
            }
        }
    }

    /**
     * 
     */

    private spielManager mySpielManager;

    public Uebung_Schiffe_Versenken(){
        mySpielManager = new spielManager();
        mySpielManager.loadData(3,3);
    }
    public static void main(String[] args) {
        Uebung_Schiffe_Versenken myGame = new Uebung_Schiffe_Versenken();
        myGame.mySpielManager.start();
        
    }
}
