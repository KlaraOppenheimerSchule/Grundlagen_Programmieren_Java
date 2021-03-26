import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class system {
    //33 -> 47, 58 -> 64, 91 -> 96, 123 -> 126 Sonderzeichen
    //48 -> 57 Ziffer
    //65 -> 90 Gorßbuchstabe
    //97 -> 122 Kleinbuscstabe
    final private int[] zifferLimits = {48,57};
    final private int[] großbuchstabeLimits = {65,90};
    final private int[] kleinBuchstabeLimits = {97,122};
    final private ArrayList<ArrayList<Integer>> sonderZeichenLimits;
    final private int passwortGroße = 10;

    public char getRandomZiffer (){
        Random random = new Random();
        int randomNumber = random.nextInt(zifferLimits[1] + 1 - zifferLimits[0]) + zifferLimits[0];
        return (char)(randomNumber);
    }

    public char getRandomGroßbuchstabe (){
        Random random = new Random();
        int randomNumber = random.nextInt(großbuchstabeLimits[1] + 1 - großbuchstabeLimits[0]) + großbuchstabeLimits[0];
        return (char)(randomNumber);
    }

    public char getRandomKleinbuchstabe (){
        Random random = new Random();
        int randomNumber = random.nextInt(kleinBuchstabeLimits[1] + 1 - kleinBuchstabeLimits[0]) + kleinBuchstabeLimits[0];
        return (char)(randomNumber);
    }

    public char getRandomSondernZeichen(){
        Random random = new Random();
        ArrayList<Integer> setSondernZeichen = sonderZeichenLimits.get(random.nextInt(4));
        int randomNumber = setSondernZeichen.get(random.nextInt(setSondernZeichen.size()));
        return (char)(randomNumber);
    }
    public system(){
        sonderZeichenLimits = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(33);
        temp.add(47);
        sonderZeichenLimits.add(temp);
        ArrayList<Integer> temp2 = new ArrayList<Integer>();
        temp2.add(58);
        temp2.add(64);
        sonderZeichenLimits.add(temp2);
        ArrayList<Integer> temp3 = new ArrayList<Integer>();
        temp3.add(91);
        temp3.add(96);
        sonderZeichenLimits.add(temp3);
        ArrayList<Integer> temp4 = new ArrayList<Integer>();
        temp4.add(123);
        temp4.add(126);
        sonderZeichenLimits.add(temp4);
    }

    public String erzeugNewPassword(){
        String newPasswort = "";

        ArrayList<Integer> temp = new ArrayList<Integer>();
        //Mindestens mussen jede Funktion mindestens einmal angeruft werden
        // großbuchstabe   klienbuchstabe   zeichen      ziffer
        temp.add(0);      temp.add(1);     temp.add(2);  temp.add(3);

        Random random = new Random();
        int choice = 0;

        for(int i = 0 ; i < this.passwortGroße ; i++){
            //die List ist nicht leer, d.h. das Passwort enhielt nicht alle Bedindungen(Ziffer, Buchstaben, Sonderzeichen)
            if(temp.size()>0){
                choice = random.nextInt(temp.size());
            }
            //das Passwort enhielt schon alle Bedindungen, dann rufen eine zufällige Funktion
            else
                choice = random.nextInt(4);
            switch (choice){
                case 0: 
                    newPasswort=newPasswort.concat(String.valueOf(this.getRandomGroßbuchstabe()));
                break;
                case 1: 
                    newPasswort=newPasswort.concat(String.valueOf(this.getRandomKleinbuchstabe()));
                break;
                case 2: 
                    newPasswort=newPasswort.concat(String.valueOf(this.getRandomSondernZeichen()));
                break;
                default: 
                    newPasswort=newPasswort.concat(String.valueOf(this.getRandomZiffer()));
                break;
            }
            //Entfernung des Indexes
            if(temp.size()>0)
                temp.remove(choice);
        }
        return newPasswort;
    }
    public static void main(String[] args) {
        system myManager = new system();
        System.out.println(myManager.erzeugNewPassword());
        
        //System.out.println("Ziffer:"+myManager.getRandomZiffer());
        //System.out.println("Großbuchstabe:"+myManager.getRandomGroßbuchstabe());
        //System.out.println("Kleinbuchstabe:"+myManager.getRandomKleinbuchstabe());
        //System.out.println("Sondernzeichen:"+myManager.getRandomSondernZeichen());
    }
    
}
