import java.util.ArrayList;
import java.util.List;


public class spieler {
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
                if(co2D.getX() == co.getX() && co2D.getY() == co.getY() ){
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
