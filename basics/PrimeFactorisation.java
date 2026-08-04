import java.util.Scanner;

public class PrimeFactorisation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // n = 315
        for(int div = 2; div * div <= n; div++){
            while(n%div == 0){ //div = 5        
                System.out.println(div);
                n = n/div;      //35
            }
          
        }

          if(n>1){
                System.out.println(n);
            }
     }
}