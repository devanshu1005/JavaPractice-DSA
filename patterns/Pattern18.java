import java.util.Scanner;

//                         *
//                         *       *
//                         *       *       *
// *       *       *       *       *       *       *
//                         *       *       *
//                         *       *
//                         *

public class Pattern18{
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();  
        int sp = 0;
        int st = n;
        
        for(int i = 1; i <=n; i++){
            int column = 1;
            // System.out.println(sp + " , " + st);

            for(int j = 1; j<=sp; j++){
                System.out.print("\t");
                column++;
            }


            for(int j = 1; j<=st; j++){

                if(i <= n/2 && i != 1){

                    if((i+ column == n+1) || i == column){
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                    
                    
                }else {
                    System.out.print("*\t");
                }
               column++;
            }

            if(i<= n/2){
                sp++;
                st-=2;
            } else {
                sp--;
                st+=2;
            }
            
            System.out.println();
        }
            
        }

        }

