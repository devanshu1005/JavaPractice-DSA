import java.util.Scanner;

//                 *
//         *               *
// *                               *
//         *               *
//                 *

public class Pattern10{
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); 
       int spb = n/2;
        int spa = 1;
        for(int i = 1; i <= n; i++){
        // System.out.println(spb + " , * " + spa + " *" );
        for(int j = 1; j<= spb; j++){
            System.out.print("\t");
        }
        System.out.print("*\t");

        if(i != 1 && i!=n){
            for (int j = 1; j<= spa; j++){
                System.out.print("\t");
            }
            System.out.print("*\t");
        }


        if(i <= (n/2)){
            spb--;
            if(i != 1 && i!=n){
                spa+=2;
            }
        } else {
            spb++;
            if(i != 1 && i!=n){
                spa-=2;
            }
        }
    
         System.out.println();
     }
     }
}
