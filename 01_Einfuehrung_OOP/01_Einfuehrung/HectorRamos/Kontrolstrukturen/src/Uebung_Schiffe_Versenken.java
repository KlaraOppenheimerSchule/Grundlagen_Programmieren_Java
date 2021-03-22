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
        protected List<coordenate2D> schiffePositionen;
        protected List<coordenate2D> visitedPositionen;
        protected char[][] grid;
        protected int lives;

        public int getLives() {
            return lives;
        }
        public void setLives(int lives) {
            this.lives = lives;
        }
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
                   System.out.print(" "+this.grid[row][col]+" ");
                }
                System.out.println();
             }
        }

        public spieler(){
            this.schiffePositionen = new ArrayList<coordenate2D>();
            this.visitedPositionen = new ArrayList<coordenate2D>();
            this.lives = 0;
        }
        public coordenate2D tippen(){
            return new coordenate2D();
        }

        public boolean tippPruefen(coordenate2D co){
            return false;
        }
        
    }
    public class computerSpieler extends spieler{
        //konstruktor
        public computerSpieler(){
            this.schiffePositionen = new ArrayList<coordenate2D>();
            this.visitedPositionen = new ArrayList<coordenate2D>();
            this.lives = 0;
        }
        //von Oberklasse
        public List<coordenate2D> getSchiffePositionen() {
            return super.getSchiffePositionen();
        }
        public boolean addSchiff(coordenate2D co){
            return super.addSchiff(co);
        }

        public void createGrid (int große){
            super.createGrid(große);
        }

        public void showGrid (){
            super.showGrid();
        }
        //Besondere Funktionen
        /**
         * erzeugt ein nicht besuchte random 2D Koordenate
         */
        public coordenate2D tippen(){
            Random rand = new Random();
            coordenate2D co = new coordenate2D();
            boolean alreadyVisited;
            do{
                alreadyVisited = false;
                co.setX(rand.nextInt(this.grid[0].length));
                co.setY(rand.nextInt(this.grid[0].length));
                for (coordenate2D co2D : this.visitedPositionen) {
                    if(co2D.x == co.x && co2D.y == co.y ){
                        alreadyVisited = true;
                    }
                }
            }while(alreadyVisited == true);
            this.visitedPositionen.add(co);
            return co;
        }
        /****
         * 
         * return true, wenn keine mehr Leben mehr verfügbar sind
         * @param co coordenate 2D (x,y)
         * 
         */
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
    public class menschlicherSpieler extends spieler{}

    /****
     * Hauptklasse, die verantwortlich für die Phasen des Spiel ist
     */
    public class spielManager{
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
                        System.out.println("( "+coPo.x + " , "+ coPo.y+" )");
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
                System.out.println("Firing at:"+"( "+co.x+" , "+co.y+" )");

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

    /**
     * 
     */

    private spielManager mySpielManager;

    public Uebung_Schiffe_Versenken(){
        mySpielManager = new spielManager();
    }
    public static void main(String[] args) {
        Uebung_Schiffe_Versenken myGame = new Uebung_Schiffe_Versenken();
        myGame.mySpielManager.createGame(3,3,3);
        myGame.mySpielManager.start();
        myGame.mySpielManager.showScores();
        
    }
}
