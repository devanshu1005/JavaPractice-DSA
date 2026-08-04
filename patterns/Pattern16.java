import java.util.Scanner;

// 1                                               1
// 1       2                               2       1
// 1       2       3               3       2       1
// 1       2       3       4       3       2       1

public class Pattern16{
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();  
        int st = 1;
        int sp = (2*n) - 3;
        for(int i = 1; i<= n; i++){

            int val = 1;
           

            for(int j = 1; j <= st; j++){
                System.out.print(val+ "\t");
                val++;
                if(i == n && j == n){
                    val--;
                }
            }

             for(int j = 1; j <= sp; j++){
                System.out.print("\t");
               
            }

             for(int j = 1; j <= st; j++){
                if(i == n && j == n){
                    break;
                }
                
                System.out.print(val-1+"\t");
                val--;
            }

            st++;
            sp-=2;
            System.out.println();
        }

        }
     }

