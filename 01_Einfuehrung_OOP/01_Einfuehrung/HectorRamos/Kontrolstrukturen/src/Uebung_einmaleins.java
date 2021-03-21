public class Uebung_einmaleins {
    public void zeigtTabelle(){
        int i = 0;
        int j = 0;
        while(i<10){
            while(j<10){
                System.out.print((i+1)*(j+1));
                j++;
            }
            System.out.print("\n");
            i++;
            j=0;
        }
    }
    public static void main(String[] args) {
        Uebung_einmaleins myClass = new Uebung_einmaleins();
        myClass.zeigtTabelle();
       
    }
}
