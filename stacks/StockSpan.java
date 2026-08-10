import java.util.Scanner;
import java.util.Stack;

//i/p == {2, 5, 9, 3, 1, 12, 6, 8, 7};

//o/p = 1       2       3       1       1       6       1       2       1    

public class StockSpan{
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
         int[] arr = {2, 5, 9, 3, 1, 12, 6, 8, 7};
        Stack<Integer> st = new Stack<>();
        int[] arrA = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            while(st.size() > 0 && arr[(int)st.peek()]<= arr[i]){
                st.pop();
            }
            if(st.size() == 0){
                arrA[i] = i + 1;
            } else {
                arrA[i] = i - (int)st.peek();
            }
            st.push(i);
        }

       

        for(int i = 0; i< arrA.length; i++){
            System.out.print(arrA[i] + "\t");
        }
     }
}