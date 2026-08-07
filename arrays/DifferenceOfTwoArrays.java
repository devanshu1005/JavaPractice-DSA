import java.util.Scanner;


public class DifferenceOfTwoArrays{

    public static int[] takeInput(Scanner scn, int n){
        int[] arr = new int[n];
        for(int i = 0; i< arr.length; i++){
            arr[i] = scn.nextInt();
       }
        System.out.println("Input finished");

       return arr;
    }

  
    public static int[] findDifference(int[] arr1, int[] arr2){
        int[] arrDiff = new int[arr1.length];
        int carry = 0;
      
      for(int i = 0; i<arr1.length; i++){
        int dig1 = 0;
        int dig2 = 0;

         if(arr1.length - (i+1) >= 0){
            dig1 = arr1[arr1.length - (i+1)];
        }
        
        if(arr2.length - (i+1) >= 0){
            dig2 = arr2[arr2.length - (i+1)];
        }
//dig1 = 3     dig2 = 3        carry = 0       diff =        arrDiff= [_,_,_]
        if(dig1 <= dig2){
           
            if((dig1 + carry) == dig2){
                int diff = dig1 - dig2;
                arrDiff[arr1.length - (i+1)] = diff;
                carry = 0;
            }else {
            int diff = ((dig1 + 10) + carry) - dig2;
            arrDiff[arr1.length - (i+1)] = diff;
            carry = -1;
            }
        } else {
            int diff = dig1 + carry - dig2;
            arrDiff[arr1.length - (i+1)] = diff;
            carry = 0;
        }

      }
      return arrDiff;
    }


     public static void main(String[] args) {          
        Scanner scn = new Scanner(System.in);
        boolean ifFirstDigitNonZero = true;

        int n1 = scn.nextInt();
        int[] arr1 =  takeInput(scn, n1);

        int n2 = scn.nextInt();
        int[] arr2 =  takeInput(scn, n2);


        int[] diff = findDifference(arr1, arr2);

        for(int i = 0; i<diff.length; i++){
            if(diff[i] == 0 && ifFirstDigitNonZero == true){
            // System.out.print();
            } else {
            System.out.print(diff[i]);
            ifFirstDigitNonZero = false;
            }
        }

        if(ifFirstDigitNonZero){
             System.out.print(0);
        }

     }
}