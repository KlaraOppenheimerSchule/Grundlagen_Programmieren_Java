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
            for (coordenate2D co2D : this.schiffePositionen){
                if(co2D.x == co.x && co2D.y == co.y ){
                    return false;
                }
            }
            schiffePositionen.add(co);
            return true;
        }

        public void createGrid (int große){
            this.grid = new char[große][große];
            for(int i=0; i<große; i++) 
                for(int j=0; j<große; j++) 
                    this.grid[i][j] = '▫';
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
            this.lives = 3;
        }
        public coordenate2D tippen(){
            Random rand = new Random();
            coordenate2D co = new coordenate2D();
            int int_random;
            boolean alreadyVisited;
            do{
                alreadyVisited = false;
                int_random = rand.nextInt(3);
                co.setX(rand.nextInt(3));
                co.setY(rand.nextInt(3));
                for (coordenate2D co2D : this.visitedPositionen) {
                    if(co2D.x == co.x && co2D.y == co.y ){
                        alreadyVisited = true;
                    }
                }
            }while(alreadyVisited == true);
            this.visitedPositionen.add(co);
            return co;
        }

        public boolean tippPruefen(coordenate2D co){
            for (coordenate2D co2D : this.schiffePositionen) {
                if(co2D.x == co.x && co2D.y == co.y ){
                    lives--;
                    System.out.println("Impact!!!!");
                    this.grid[co.x][co.y] = '*';
                    this.showGrid();

                    if(lives<1)
                        return true;
                    return false;
                }
            }
            System.out.println("Nothing!!!");
            return false;
        }
        
    }
    public class computerSpieler extends spieler{}
    public class menschlicherSpieler extends spieler{}

    /****
     * 
     */
    public class spielManager{
        private Scanner s;
        private List<computerSpieler> spielers;

        private boolean gameEnded   = false;
        private int passiveSpieler = 0;
        private int activSpieler   = 0;

        public spielManager(){
            this.spielers = new ArrayList<computerSpieler>();
            this.spielers.add(new computerSpieler());
            this.spielers.add(new computerSpieler());
            s = new Scanner(System.in);
        }
        
        public void loadData (int gridGroße, int totalSchiffe){
                int counter;
                int i = 0;
                
                for (computerSpieler cs : this.spielers) {
                    cs.createGrid(gridGroße);
                    
                    counter = 0;
                    while(counter< totalSchiffe){
                        Random rand = new Random();
                        coordenate2D co = new coordenate2D();
                        int int_random = rand.nextInt(3);
                        co.setX(rand.nextInt(3));
                        co.setY(rand.nextInt(3));
                        if(cs.addSchiff(co))
                            counter++;
                    }

                    System.out.println("Spiler´s"+i+" Schiffe:");
                    for (coordenate2D coPo : cs.getSchiffePositionen()) {
                        System.out.println("( "+coPo.x + " , "+ coPo.y+" )");
                    }
                    i++;
                }
        }
        
        public void start(){
            passiveSpieler = 1;
            activSpieler   = 0;
            int temp = 0;
            do{
                System.out.println("Spieler in Turn:"+activSpieler);
                coordenate2D co = this.spielers.get(activSpieler).tippen();
                System.out.println("Trying at:"+"( "+co.x+" , "+co.y+" )");
                gameEnded = this.spielers.get(passiveSpieler).tippPruefen(co);
                if(gameEnded)
                    System.out.println("Spieler"+activSpieler+"gewonnen");
                //s.nextLine();
                //change the order
                temp = passiveSpieler;
                passiveSpieler = activSpieler;
                activSpieler = temp;
            }while(!this.gameEnded);
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
