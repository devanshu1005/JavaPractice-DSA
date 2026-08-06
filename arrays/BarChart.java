import java.util.Scanner;

public class BarChart{
     public static void main(String[] args) {                   //[2,  3,  6,  4,  2]       l = 6       barSize = 5
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
       int[] arr = new int[n];

       for(int i = 0; i< arr.length; i++){
        arr[i] = scn.nextInt();
       }

       //find largest           i = 2       j=4                  _    _    *    _   _    
//                                                               
       int l = arr[0];

       for(int i = 1; i<arr.length; i++){
        if(arr[i] > l){
            l = arr[i];
        }
       }

       System.out.println("largest: " + l);
        int barSize = l;
        for(int i = 1; i <= l; i++){
            for(int j = 0; j<arr.length; j++){
                if(arr[j] >= barSize){
                    System.out.print("*\t");
                    // arr[j] = arr[j] - 1;
                } else {
                    System.out.print("\t");
                }
               
            }
             barSize--;
            System.out.println();
        }
     }
}