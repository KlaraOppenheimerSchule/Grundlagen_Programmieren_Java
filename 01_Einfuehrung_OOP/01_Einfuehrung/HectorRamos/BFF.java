import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MyClass {
            private String friends[];
            private Scanner s;
            
            public MyClass(){
                this.friends = new String[3];
                s = new Scanner(System.in);
            }
            
            public void modifyFriend(boolean _friendly){
                String _name = s.nextLine();
                List<String> itemList = new ArrayList<String>();
                //itemList = Arrays.asList(this.friends); 
                Collections.addAll(itemList, this.friends);
                
                if(friends==null)
                    System.out.println("friends null");
                    
                if(itemList==null)
                    System.out.println("item List null");
                if(_friendly){
                    if(itemList.contains(_name))
                        System.out.println(_name+" ist schon deinen Freund");
                    else{
                        itemList.add(_name);
                        System.out.println(_name+" ist jetzt deinen Freund");
                    }
                }
                else{
                    if(!itemList.contains(_name))
                        System.out.println(_name+" ist nicht deinen Freund");
                    else{
                        itemList.remove(_name);
                        System.out.println(_name+" ist nicht mehr deinen Freund");
                    }
                }
                
                this.friends = itemList.toArray(this.friends);
            }
            public void showFriends(){
                System.out.println("Deine Freunde sind:");
                for(String name : this.friends) {
                    System.out.println(name);
                }
            }
            
   
        
        
    public static void main(String args[]) {

        MyClass friendlist = new MyClass();
        
        System.out.println("Neuer Freund 1");
        friendlist.modifyFriend(true);
        friendlist.showFriends();
        System.out.println("Neuer Freund 2");
        friendlist.modifyFriend(true);
        System.out.println("Neuer Freund 3");
        friendlist.modifyFriend(true);
        
        System.out.println("Remove Freund");
        friendlist.modifyFriend(false);
        System.out.println("Neuer Freund");
        friendlist.modifyFriend(true);

    }
}