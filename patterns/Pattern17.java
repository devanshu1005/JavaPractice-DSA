import java.util.Scanner;

//                         *
//                         *       *
//                         *       *       *
// *       *       *       *       *       *       *
//                         *       *       *
//                         *       *
//                         *

public class Pattern17{
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();  
        int sp = n/2;
        int st = 1;
        for(int i = 1; i <=n; i++){

                //i = 3     sp = 2      st = 3      n/2 = 2

            if(i == (n/2) + 1){
                //  System.out.println(0 + "," + 5);
                for(int j = 1; j<= n; j++){
                    System.out.print("*\t");
                }
                 st++;
            } else {
                // System.out.println(sp + "," + st); 
                 for(int j = 1; j<= sp; j++){
                    System.out.print("\t");
                }

                 for(int j = 1; j<= st; j++){
                    System.out.print("*\t");
                } 
            }
           
            if(i<n/2){
                st++;
            }else if(i > n/2){
                st--;
            }

            System.out.println();
        }
            
        }

        }

