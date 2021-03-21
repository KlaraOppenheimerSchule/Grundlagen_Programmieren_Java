import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;

public class rezepten {
    public Scanner scan;
    private boolean gesetzlichePatient = false;
    private boolean verschreibungspflichtigesArzneimittel = false;
    private boolean unterBetäubungsmittelgesetz = false;

    public void readEingaben(){
        scan = new Scanner(System.in);

        System.out.println("Ist ein gesetzlicher versicherter Patient");
        if(scan.nextLine().toUpperCase().equals("JA"))
            this.gesetzlichePatient = true;

        System.out.println("Ist das Arzneimittel verschreibungspflichtig?");
        if(scan.nextLine().toUpperCase().equals("JA"))
            this.verschreibungspflichtigesArzneimittel = true;
        
        System.out.println("Fallen die Arzneimitter unter das Betäubungsmittelgesetz?");
        if(scan.nextLine().toUpperCase().equals("JA"))
            this.unterBetäubungsmittelgesetz = true;
    }
    public constants.farbeRezept findRezeptFarbe(){
        if(this.gesetzlichePatient){
            if(this.verschreibungspflichtigesArzneimittel){
                if(this.unterBetäubungsmittelgesetz)
                    return constants.farbeRezept.gelbe;
                else    
                    return constants.farbeRezept.rosa;
            }
            return constants.farbeRezept.grun;
        }
        else{
            if(this.verschreibungspflichtigesArzneimittel){
                if(this.unterBetäubungsmittelgesetz)
                return constants.farbeRezept.gelbe;
                else 
                    return constants.farbeRezept.blau;
            }
            return constants.farbeRezept.blau;
        }
    }

    @Before
    public void setUp(){
        this.readEingaben();
    }
    @Test
    public void execute(){
                        //assertEquals(expected, actual);
        assertEquals(constants.farbeRezept.grun, this.findRezeptFarbe());
    }
    @After
    public void end(){
        
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run( new JUnit4TestAdapter(rezepten.class) );
    }
}
