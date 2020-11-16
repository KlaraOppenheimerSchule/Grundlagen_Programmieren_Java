public class einmaleins {
    public static void main(String[] args) {
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
}
