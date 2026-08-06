import java.util.Scanner;

//TODO: incomplete
//output should also be in form of array. Currently it is in form of int

public class SumOfTwoArrays{
     public static void main(String[] args) {          
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
       int[] arr1 = new int[n1];

       for(int i = 0; i< arr1.length; i++){
        arr1[i] = scn.nextInt();
       }

        System.out.println("first input finished");

        int n2 = scn.nextInt();
       int[] arr2 = new int[n2];

       for(int i = 0; i< arr2.length; i++){
        arr2[i] = scn.nextInt();
       }

        int lar = arr1.length;

        if(arr2.length > arr1.length){
            lar = arr2.length;
        }

        int multiplier = 1;
        int ans = 0;
        int carry = 0;

        for(int i = 1; i<= lar; i++){
        int dig1 = 0;
        int dig2 = 0;
        if(arr1.length - i >= 0){
            dig1 = arr1[arr1.length - i];
        } 

         if(arr2.length - i >= 0){
            dig2 = arr2[arr2.length - i];
        }
// carry = 1    dig1 = 7    dig2= 6     multiplier = 10     ans = 9     dig = 3

        if(dig1 + dig2 > 9){
            int dig = (dig1 + dig2)%10;
            ans = ans + (dig + carry) * multiplier;
            carry = (dig1 + dig2)/10;
        }else {
            ans = ans + (dig1 + dig2 + carry) * multiplier;
            carry = 0;
        }
          
          multiplier *= 10;
        }
        if(carry != 0){
            ans = ans + (carry * multiplier);
        }

        System.out.println("Ans: " + ans);

     }
}