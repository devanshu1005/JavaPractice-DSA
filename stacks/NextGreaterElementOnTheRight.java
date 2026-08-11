import java.util.Scanner;
import java.util.Stack;

//i/p == {2, 5, 9, 3, 1, 12, 6, 8, 7};

//o/p = 5       9       12      12      12      -1      8       -1      -1    

public class NextGreaterElementOnTheRight{
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
         int[] arr = {6, 2, 5, 4, 5, 1, 6};
        Stack<Integer> st = new Stack<>();
        int[] arrA = new int[arr.length];

        //Approach 2
        //     st.push(0);
        // for(int i = 1; i< arr.length; i++){
        //     while ((st.size()> 0)&& (arr[i] > arr[(int) st.peek()])){
        //         arrA[(int) st.peek()] = arr[i];
        //         st.pop();
        //     }
        //         st.push(i);

        // }

        // while(st.size() != 0){
        //     arrA[(int) st.peek()] = -1;
        //     st.pop();
        // }

        //Approach 1

        // for(int i = arr.length - 1; i>=0; i--){
        //     while(st.size() > 0 && arr[i] >= st.peek()){
        //         st.pop();
        //     }

        //     if(st.size() > 0 ){
        //         arrA[i] = (int)st.peek();

        //     } else {
        //         arrA[i] = -1;
        //     }
        //     st.push(arr[i]);
        // }

        //for priting indexes of next greater element

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



        for(int i = 0; i< arrA.length; i++){
            System.out.print(arrA[i] + "\t");
        }
     }
}