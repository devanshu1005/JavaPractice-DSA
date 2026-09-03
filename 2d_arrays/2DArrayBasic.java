import java.util.Scanner;

public class TwoDArrayBasic{
     public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int m = scn.nextInt();
        int n = scn.nextInt();

       int[][] arr = new int[m][n];


       for(int i = 0; i< m; i++){
        // System.out.println(arr[i]);
        for(int j = 0; j<n; j++){
            arr[i][j] = scn.nextInt();
        }
       }

       for(int i = 0; i< arr.length; i++){
        for(int j = 0; j<arr[i].length; j++){
           System.out.print(arr[i][j] + " ");
        }
        System.out.println();
       }

     }
}