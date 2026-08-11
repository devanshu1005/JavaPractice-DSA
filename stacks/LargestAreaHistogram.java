import java.util.Scanner;
import java.util.Stack;

// TODO: Incomplete

//i/p == {6,2,5,4,5,1,6};2

//o/p = 4

public class LargestAreaHistogram{
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
         int[] arr = {6, 2, 5, 4, 5, 1, 6};
        Stack<Integer> st = new Stack<>();
        int[] arrA = new int[arr.length];
        int index

       for(int i = arr.length - 1; i >= 0; i--){
            if(st.size() > 0){
                //pop
                while(st.size() > 0 && arr[(int)st.peek()] <= arr[i]){
                    st.pop();
                }

                //print ans
                if(st.size() > 0){
                arrA[i] = st.peek() - i;
                } else {
                    arrA[i] = 0;
                }
               

                //push
                st.push(i);
            
           } else {
                arrA[i] = 0;

                 st.push(i);
           }

        }
       

        for(int i = 0; i< arrA.length; i++){
            System.out.print(arrA[i] + "\t");
        }
     }
}