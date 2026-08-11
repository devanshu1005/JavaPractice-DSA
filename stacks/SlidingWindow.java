import java.util.Scanner;
 import java.util.Stack;

 //TODO: incomplete


public class SlidingWindow{

    public static int[] nextGreaterElement(int[] arr, Stack<Integer> st){
        int[] arrA = new int[arr.length];
   for(int i = arr.length - 1; i>=0; i--){
            while(st.size() > 0 && arr[i] >= arr[(int)st.peek()]){
                st.pop();
            }

            if(st.size() > 0 ){
                arrA[i] = (int)st.peek();

            } else {
                arrA[i] = -1;
            }
            st.push(i);
        }
        return arrA;
    }
    
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
         int[] arr = {2,9,3,8,1,7,12,6,14,4,32,0,7,19,8,12,6};
        Stack<Integer> st = new Stack<>();

        int k = 4;

        int[] arrA = new int[arr.length - k];

        int[] arrNGEI = new int[arr.length];

        arrNGEI = nextGreaterElement(arr, st);

        int j = 0;

         //i = [0, 1, 2]
         //j = [0, 1, 6]

     // arrA = [9, 9, ]

        for(int i= 0; i< arr.length - k; i++){
            // j = i;
            // while(i <= j && j < ){
                if(arrNGEI[j] < i+3){
                    arrA[j] = arr[arrNGEI[j]];
                }else {
                    arrA[j] = arr[j];
                }
                j = arrNGEI[j];
            // }
                //  arrA[j] = arr[j];
                //  j++;
            System.out.print(arrA[i] + "\t");
        }

            // System.out.print("for loop completed");
        


        // for(int i = 0; i< arrA.length; i++){
        //     System.out.print(arrA[i] + "\t");
        // }

       
     }
}