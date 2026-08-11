import java.util.Scanner;
 import java.util.Stack;


public class LargestAreaHistogram{

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

        int[] arrA = new int[arr.length];

        arrA = nextGreaterElement(arr, st);


        for(int i = 0; i< arrA.length; i++){
            System.out.print(arrA[i] + "\t");
        }

       
     }
}