import java.util.Scanner;

public class SpanOfAnArray{
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(n);
       int[] arr = new int[n];

       for(int i = 0; i< arr.length; i++){
        arr[i] = scn.nextInt();
       }

       int s = arr[0];
       int l = arr[1];

       for(int i = 0; i<arr.length; i++){
        if(s > arr[i]){
            s = arr[i];
        }

        if(l<arr[i]){
            l = arr[i];
        }
       }

       int ans = l - s;

        System.out.println("ans: " + ans);

     }
}