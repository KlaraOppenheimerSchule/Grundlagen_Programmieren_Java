import java.util.ArrayList;
import java.util.Random;

public class computerSpieler extends spieler{
    //konstruktor
    public computerSpieler(){
        this.schiffePositionen = new ArrayList<coordenate2D>();
        this.visitedPositionen = new ArrayList<coordenate2D>();
        this.lives = 0;
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
                if(co2D.getX() == co.getX() && co2D.getY() == co.getY() ){
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
            if(co2D.getX() == co.getX() && co2D.getY() == co.getY() ){
                lives--;
                System.out.println("Impact!!!!");
                this.grid[co.getX()][co.getY()] = '*';
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
