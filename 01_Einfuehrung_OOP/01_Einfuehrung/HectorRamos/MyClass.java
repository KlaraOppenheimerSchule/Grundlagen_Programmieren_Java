import java.util.Scanner;
import java.util.regex.Pattern;

public class MyClass{
    public String b1,b2,b3,b4;
    enum Klasse{
        A,
        B,
        C
    }
    public String[] fnSplitString(String sIpAddresse, String c){
        String[] result = sIpAddresse.split(c);
        return result;
    }
    public int[] fnStringToInt(String[] sOhnePunkte){
        int[] p = new int[4];
        for(int i=0;i<sOhnePunkte.length ; i++){
            p[i]= Integer.parseInt(sOhnePunkte[i]);
        }
        return p;
    }
    public String[] fnIntToByte(int[] iBytes){
        String[] s = new String[4];
        for(int i=0;i<iBytes.length;i++){
            s[i]= Integer.toBinaryString(iBytes[i]);
        }
        return s;
    }
    public boolean fnValidUrl(String[] sOhnePunkte){
        //uberpruft url große, 4 bytes
        if(sOhnePunkte.length > 4){
            System.out.println("IpAddresse zu groß");
                return true;
        }
        if(sOhnePunkte.length < 4){
            System.out.println("IpAddresse zu klein");
                return true;
        }
        //uberpruft ob es ein Buchstabe
        for(int i = 0; i<sOhnePunkte.length ; i++){
            if (Pattern.matches("[a-zA-Z]+", sOhnePunkte[i])){
                System.out.println("Buchstaben sind nicht erlauben");
                return true;
            }
        }
        return false;
    }
    public boolean fnMax255Min0(int[] iBytes){
        for(int i = 0; i<iBytes.length ; i++){
            if (iBytes[i] > 255 || iBytes[i] < 0) {
                System.out.println("nummer außerhalb des Bereichs");
                return true;
            }
        }
        return false;
    }

    public String[] fnFillWith0(String[] sBytes){
        if(sBytes[0].length() < 8){
            do{
                sBytes[0] = sBytes[0].substring(0, 0) + '0' + sBytes[0].substring(0);
            }while(sBytes[0].length() <8);
        }
        return sBytes;
    }

    public boolean fnGetKlasse(String[] sBytes, int[]    iBytes,Klasse k ){
        if(k == Klasse.A)
        {
            //local host
            if(iBytes[0] == 127){
                System.out.println("Diese IpAddresse ist reserviert für LocalHost. Klasse A");
                        return false; 
            }
            else if(iBytes[0] == 0){
                System.out.println("Diese IpAddresse ist reserviert für Routing. Klasse A");
                        return false; 
            }
            else if( sBytes[1].length() < 2 && sBytes[1].charAt(0) == '0' && 
                    sBytes[2].length() < 2 && sBytes[2].charAt(0) == '0' && 
                    sBytes[3].length() < 2 && sBytes[3].charAt(0) == '0'){
                        System.out.println("Diese IpAddresse ist reserviert für NetzAddrese. Klasse A");
                        return false; 
                    }
            else if( iBytes[1] == 255 && 
                    iBytes[2] == 255 &&
                    iBytes[3] == 255 ){
                        System.out.println("Diese IpAddresse ist reserviert für Broadcast. Klasse A");
                        return false;
                    }            
            else
                    return true;
        }
        else if(k == Klasse.B){
            if(sBytes[2].length() < 2 && sBytes[2].charAt(0) == '0' && 
               sBytes[3].length() < 2 && sBytes[3].charAt(0) == '0'){
                        System.out.println("Diese IpAddresse ist reserviert für NetzAddrese. Klasse B");
                        return false; 
                    }
            else if(iBytes[2] == 255 &&
                    iBytes[3] == 255 ){
                        System.out.println("Diese IpAddresse ist reserviert für Broadcast. Klasse B");
                        return false;
                    }
            else
                return true;
        }
        else if(k == Klasse.C){
            if(sBytes[3].length() < 2 && sBytes[3].charAt(0) == '0'){
                        System.out.println("Diese IpAddresse ist reserviert für NetzAddrese. Klasse C");
                        return false; 
                    }
            else if(iBytes[3] == 255 ){
                        System.out.println("Diese IpAddresse ist reserviert für Broadcast. Klasse C");
                        return false;
                    }
            else
                return true;
        }
        return false;
    }
     public static void main(String []args){
         
        Scanner s = new Scanner(System.in);
        System.out.println("Bitte Schreiben Sie eine Ip Addresse");
        String sIpAddresse = s.nextLine();
        s.close();
        
        MyClass test = new MyClass();
        //trennt 
        String[] sOhnePunkte = test.fnSplitString(sIpAddresse,"[.]");
        //uberpruft ob die IpAddresse Buchstaben enhält, oder ob zu groß oder zu klein
        if(test.fnValidUrl(sOhnePunkte))
            return;
        int[]    iBytes = test.fnStringToInt(sOhnePunkte);
        //uberpruft ob die Nummern größer als 255 oder kleiner als 0 sind
        if(test.fnMax255Min0(iBytes))
            return;
        String[] sBytes = test.fnIntToByte(iBytes);
        //z.B 126 = 1111110 -> 01111110
        sBytes = test.fnFillWith0(sBytes);

        //klasse A
        if(sBytes[0].charAt(0) == '0'){
                if(test.fnGetKlasse(sBytes, iBytes, Klasse.A))
                    System.out.println("gültiger IpAddresse klasse A");
        }
        //klasse B
        else if(sBytes[0].charAt(1) == '0'){
            if(test.fnGetKlasse(sBytes, iBytes, Klasse.B))
                System.out.println("gültiger IpAddresse klasse B");
            }
        //klasse C
        else if(sBytes[0].charAt(2) == '0'){
            if(test.fnGetKlasse(sBytes, iBytes, Klasse.C))
                System.out.println("gültiger IpAddresse klasse C");
        }
        //klasse D
        else    
            System.out.println("klasse D, nicht möglich");
     }
}