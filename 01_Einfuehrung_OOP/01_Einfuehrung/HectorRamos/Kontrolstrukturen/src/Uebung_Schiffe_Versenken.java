public class Uebung_Schiffe_Versenken {
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
