import java.util.Scanner;

//TODO: incomplete

public class Pattern15{
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();  //n = 5
        int sp = n/2; // sp = 1
        int st = 1;  //st = 3
        for(int i = 1; i <= n; i++){
            // System.out.println(sp + " , " + st);

            for(int j = 1; j<=sp; j++){ 
                System.out.print("\t");
            }

             for(int j = 0; j<st; j++){          //i = 2      //j = 2     n/2 = 2
                
                if(i<= (n/2)){
                    if(j<(n/2)){
                             System.out.print((i+j)+"\t");
                    } else {
                        //  System.out.print(i+" i\t");
                        //  System.out.print(j+" j\t");
                          System.out.print("*\t");
                    }
                   
                }else {
                    if(j<(n/2)  || (i+j)== n){
                            System.out.print((((n+1)-i)+j)+"\t");
                    }else {
                        //  System.out.print(i+" i\t");
                        //  System.out.print(j+" j\t");
                          System.out.print("*\t");
                          
                    }
                   
                }
               
            }

            if(i <= (n/2)){
                sp--;
                st+=2;
            }else{
            sp++;
            st-=2;
        }
System.out.println();
        }
     }
}
