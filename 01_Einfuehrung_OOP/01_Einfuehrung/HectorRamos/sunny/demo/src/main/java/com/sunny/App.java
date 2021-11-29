package com.sunny;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        String tempString;
        String title = "";
        boolean end = false;
        float fachCount = 0;
        float gesamteNoten = 0;
        float einzelNote = 0;
        float multiplier = 1;
        Scanner s = new Scanner(System.in);
        
        do{
            fachCount = 0;
            gesamteNoten = 0;
            einzelNote = 0;
            multiplier = 1;
            System.out.println("Notenbereiche in: Deutsch drückt D , HSU drückt H, und Enter" );
            tempString = s.nextLine();
            if(tempString.equalsIgnoreCase("D")){
                do{
                    System.out.println("DEUTSCH: Auswähl des Faches:" );
                    System.out.println("1) Sprechen und Zuhören, drückt 1 und Enter" );
                    System.out.println("2) Lesen               , drückt 2 und Enter" );
                    System.out.println("3) Schreiben           , drückt 3 und Enter" );
                    System.out.println("4) Rechtschreiben      , drückt 4 und Enter" );
                    System.out.println("5) Sprachgebrauch      , drückt 5 und Enter" );
                    System.out.println("6) Engagement          , drückt 6 und Enter" );
                    System.out.println("7) Rechnen und exit    , drückt 7 und Enter" );
                    tempString = s.nextLine();
                    
                    if(tempString.matches(".*\\d.*")){
                        einzelNote = Integer.parseInt(tempString);
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

                            System.out.println("Noten von " + title );
                            end = false;
                            do
                            {
                                System.out.println("Schreib die neue Note und enter");
                                tempString = s.nextLine();
                                if(tempString.matches(".*\\d.*")){
                                    einzelNote = Integer.parseInt(tempString);
                                    if(einzelNote < 7 && einzelNote > 0){
                                        gesamteNoten+= einzelNote * multiplier;
                                        fachCount+= multiplier;
                                        System.out.println("Neues Fach? schreib: esc, noch eine Note in "+ title+" ? press etwas und enter");
                                        tempString = s.nextLine();
                                        if(tempString.toUpperCase().equals("ESC"))
                                            end = true;
                                    }
                                    else{
                                        System.out.println("Fehler:"+tempString+ ", nur Ziffern, enter to continue" );
                                        s.nextLine();
                                    }
                                }else{
                                    System.out.println("Fehler:"+tempString+ ", nur Ziffern, enter to continue" );
                                    s.nextLine();
                                }
                            }while(end == false);
                            end = false;
                        }
                        else{
                            if(einzelNote == 7)
                                end = true;
                            else{
                                System.out.println("Fehler:"+tempString+ ", nur von 1 bis xx 6" );
                                s.nextLine();
                            }
                        }
                    }else{
                        System.out.println("Fehler:"+tempString+ ", nur Ziffern, enter to continue" );
                        s.nextLine();
                    }

                }while(end == false);
                
                float f = gesamteNoten/fachCount;
                System.out.println("Abschlussnote (Deutsch): "+ Float.toString(f));

            }
            else if(tempString.equalsIgnoreCase("H")){
                do{
                    System.out.println("Probe                   , drückt 1" );
                    System.out.println("Referat                 , drückt 2" );
                    System.out.println("Praktische Note         , drückt 3" );
                    System.out.println("Portafolio              , drückt 4" );
                    System.out.println("Engagement+Mitarbeit    , drückt 5" );
                    tempString = s.nextLine();
                    
                    if(tempString.matches(".*\\d.*")){
                        einzelNote = Integer.parseInt(tempString);
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
                float f = gesamteNoten/fachCount;
                System.out.println("Abschlussnote (HSU): "+ Float.toString(f));
            }
            else{
                System.out.println("Nicht erakannt" );
                s.nextLine();
            }
            

            //do{
                end = false;
                System.out.println("neuer Schuler?(ja), to exit press enter");
                tempString = s.nextLine();
                if(!tempString.toUpperCase().equals("JA"))
                    end = true;
                System.out.print("\033[H\033[2J");  
                System.out.flush();
            //}while(end == false);
        }while(end == false);
    }
}
