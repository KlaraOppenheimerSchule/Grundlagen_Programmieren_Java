
import java.util.Scanner;
import java.util.ArrayList;
public class App {

    public static void cleanConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void showDeutschMenu(){
        System.out.println("DEUTSCH: Auswähl des Faches:" );
        System.out.println("1) Sprechen und Zuhören, drückt 1 und Enter" );
        System.out.println("2) Lesen               , drückt 2 und Enter" );
        System.out.println("3) Schreiben           , drückt 3 und Enter" );
        System.out.println("4) Rechtschreiben      , drückt 4 und Enter" );
        System.out.println("5) Sprachgebrauch      , drückt 5 und Enter" );
        System.out.println("6) Engagement          , drückt 6 und Enter" );
        System.out.println("7) Rechnen und exit    , drückt 7 und Enter" );
    }

    public static void showHRMenu(){
        System.out.println("HR: Auswähl des Faches:" );
        System.out.println("1) Probe            , drückt 1 und Enter" );
        System.out.println("2) Referat          , drückt 2 und Enter" );
        System.out.println("3) Praktische Note  , drückt 3 und Enter" );
        System.out.println("4) Portafolio       , drückt 4 und Enter" );
        System.out.println("5) Mitarbeit        , drückt 5 und Enter" );
        System.out.println("6) Rechnen und exit , drückt 6 und Enter" );
    }

    public static void main(String[] args) {
        String tempString;
        String title = "";
        boolean end = false;
        float fachCount = 0;
        float gesamteNoten = 0;
        float einzelNote = 0;
        float multiplier = 1;
        Scanner s = new Scanner(System.in);
        ArrayList<Float> noten = new ArrayList<Float>();
        do{
            fachCount = 0;
            gesamteNoten = 0;
            einzelNote = 0;
            multiplier = 1;
            System.out.println("Notenbereiche in: Deutsch drückt D , HSU drückt H, und Enter" );
            tempString = s.nextLine();
            if(tempString.equalsIgnoreCase("D")){
                do{
                   App.showDeutschMenu();
                    tempString = s.nextLine();
                    
                    if(tempString.matches(".*\\d.*")){
                        einzelNote = Integer.parseInt(tempString);
                        noten.clear();
                        if(einzelNote < 7 && einzelNote > 0){
                            switch(tempString){
                                case "1": multiplier = 2; title = "Sprechen und Zuhören"; break;
                                case "2": multiplier = 2; title = "Lesen"; break;
                                case "3": multiplier = 4; title = "Schreiben"; break;
                                case "4": multiplier = 4; title = "Rechtschreiben"; break;
                                case "5": multiplier = 2; title = "Sprachgebrauch"; break;
                                case "6": multiplier = 1; title = "Engagement"; break;
                                default: break;
                            }
                            App.cleanConsole();
                            System.out.println("Noten von " + title );
                            end = false;
                            do
                            {
                                System.out.println("Aktuelle Noten:"+noten.toString());
                                System.out.println("Schreib die Note oder ESC zu endet, und enter");
                                tempString = s.nextLine();
                                if(tempString.matches(".*\\d.*")){
                                    einzelNote = Integer.parseInt(tempString);
                                    if(einzelNote < 7 && einzelNote > 0){
                                        gesamteNoten+= einzelNote * multiplier;
                                        fachCount+= multiplier;
                                        noten.add(einzelNote);
                                        cleanConsole();
                                    }
                                    else{
                                        System.out.println("Fehler:"+tempString+ ", nur Ziffern von 1 bis 6, enter to continue" );
                                        s.nextLine();
                                        cleanConsole();
                                    }
                                }else{
                                    if(tempString.toUpperCase().equals("ESC")){
                                        end = true;
                                        cleanConsole();
                                    }else{
                                        System.out.println("Fehler:"+tempString+ ", nur Ziffern, enter to continue" );
                                        s.nextLine();
                                        cleanConsole();
                                    }
                                }
                            }while(end == false);
                            end = false;
                        }
                        else{
                            if(einzelNote == 7)
                                end = true;
                            else{
                                System.out.println("Fehler:"+tempString+ ", nur von 1 bis 6, enter to continue" );
                                s.nextLine();
                            }
                        }
                    }else{
                        System.out.println("Fehler:"+tempString+ ", nur Ziffern, enter to continue" );
                        s.nextLine();
                    }

                }while(end == false);
                
                float f = gesamteNoten/fachCount;
                System.out.println("Gesamte Note: "+ Float.toString(gesamteNoten) + "Fach Counter:" + Float.toString(fachCount));
                System.out.println("Abschlussnote (Deutsch): "+ Float.toString(f));

            }
            else if(tempString.equalsIgnoreCase("H")){
                do{
                    showHRMenu();
                     tempString = s.nextLine();
                     
                     if(tempString.matches(".*\\d.*")){
                         einzelNote = Integer.parseInt(tempString);
                         noten.clear();
                         if(einzelNote < 6 && einzelNote > 0){
                             switch(tempString){
                                 case "1": multiplier = 4; title = "Probe"; break;
                                 case "2": multiplier = 2; title = "Referat"; break;
                                 case "3": multiplier = 2; title = "Praktische Note"; break;
                                 case "4": multiplier = 2; title = "Portafolio"; break;
                                 case "5": multiplier = 1; title = "Mitarbeit"; break;
                                 default: break;
                             }
                             App.cleanConsole();
                             System.out.println("Noten von " + title );
                             end = false;
                             do
                             {
                                 System.out.println("Aktuelle Noten:"+noten.toString());
                                 System.out.println("Schreib die Note oder ESC zu endet, und enter");
                                 tempString = s.nextLine();
                                 if(tempString.matches(".*\\d.*")){
                                     einzelNote = Integer.parseInt(tempString);
                                     if(einzelNote < 7 && einzelNote > 0){
                                         gesamteNoten+= einzelNote * multiplier;
                                         fachCount+= multiplier;
                                         noten.add(einzelNote);
                                         cleanConsole();
                                     }
                                     else{
                                         System.out.println("Fehler:"+tempString+ ", nur Ziffern von 1 bis 6, enter to continue" );
                                         s.nextLine();
                                         cleanConsole();
                                     }
                                 }else{
                                     if(tempString.toUpperCase().equals("ESC")){
                                         end = true;
                                         cleanConsole();
                                     }else{
                                         System.out.println("Fehler:"+tempString+ ", nur Ziffern, enter to continue" );
                                         s.nextLine();
                                         cleanConsole();
                                     }
                                 }
                             }while(end == false);
                             end = false;
                         }
                         else{
                             if(einzelNote == 6)
                                 end = true;
                             else{
                                 System.out.println("Fehler:"+tempString+ ", nur von 1 bis 6, enter to continue" );
                                 s.nextLine();
                             }
                         }
                     }else{
                         System.out.println("Fehler:"+tempString+ ", nur Ziffern, enter to continue" );
                         s.nextLine();
                     }
 
                 }while(end == false);
                 
              /*  do{
                    showHRMenu();
                    tempString = s.nextLine();
                    
                    if(tempString.matches(".*\\d.*")){
                        einzelNote = Integer.parseInt(tempString);
                        cleanConsole();
                        if(einzelNote < 6 && einzelNote > 0){
                            switch(tempString){
                                case "1": multiplier = 4; break;
                                case "2": multiplier = 2; break;
                                case "3": multiplier = 2; break;
                                case "4": multiplier = 2; break;
                                default: multiplier = 1; break;
                            }
                            System.out.println("Note:" );
                            tempString = s.nextLine();
                            if(tempString.matches(".*\\d.*")){
                                einzelNote = Integer.parseInt(tempString);
                                if(einzelNote < 7 && einzelNote > 0){
                                    gesamteNoten+= einzelNote * multiplier;
                                    fachCount+= multiplier;
                                    System.out.println("neues Fach?(yes), anderfalls tippen nein:");
                                    tempString = s.nextLine();
                                    if(!tempString.toUpperCase().equals("JA"))
                                        end = true;
                                }
                                else{
                                    System.out.println("Fehler, nur Ziffern" );
                                    s.nextLine();
                                }
                            }else{
                                System.out.println("Fehler, nur Ziffern" );
                                s.nextLine();
                            }

                        }
                        else{
                            System.out.println("Fehler, nur von 1 bis sss 6" );
                            s.nextLine();
                        }
                    }else{
                        System.out.println("Fehler, nur Ziffern" );
                        s.nextLine();
                    }

                }while(end == false);
            */
                float f = gesamteNoten/fachCount;
                System.out.println("Gesamte Note: "+ Float.toString(gesamteNoten) + "Fach Counter:" + Float.toString(fachCount));
                System.out.println("Abschlussnote (HSU): "+ Float.toString(f));
            }
            else{
                System.out.println("Nicht erakannt, enter to continue" );
                s.nextLine();
                cleanConsole();
            }
            

            //do{
                end = false;
                System.out.println("neuer Schuler?(ja), to exit press enter");
                tempString = s.nextLine();
                if(!tempString.toUpperCase().equals("JA"))
                    end = true;
                cleanConsole();
            //}while(end == false);
        }while(end == false);
        s.close();
    }
}

