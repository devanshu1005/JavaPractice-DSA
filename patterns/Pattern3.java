import java.util.Scanner;

//         * 
//       * * 
//     * * * 
//   * * * * 
// * * * * * 

// public class Pattern3{
//     public static void main(String[] args) {
//         Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt(); 
//         for(int i = 1; i <= n; i++){
//             for(int j = 1; j <= n; j++){

//                 if((i + j) > 5){
//                 System.out.print("* ");
//                 } else 
//                 System.out.print("  ");
                
//             }
//             System.out.println("");
//         }
//      }
// }

//alternate solution

public class Pattern3{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); 
        int sp = n-1;
        int st = 1;
        for(int i = 1; i <= n; i++){
        //    System.out.println(sp + " , " + st);
        for(int j= 1; j<= sp; j++){
            System.out.print("  ");
        }
        for(int j= 1; j<= st; j++){
            System.out.print("* ");
        }
            System.out.println("");
            sp--;
            st++;
        }
     }
}