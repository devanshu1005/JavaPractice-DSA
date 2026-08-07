import java.util.Scanner;
import java.util.Stack;

//TODO: revisit and resolve this question. 

//i/p == {2, 5, 9, 3, 1, 12, 6, 8, 7};

//o/p = 5       9       12      12      12      -1      8       -1      -1    

public class NextGreaterElementOnTheRight{
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
         int[] arr = {2, 5, 9, 3, 1, 12, 6, 8, 7};
        Stack<Integer> st = new Stack<>();
        int[] arrA = new int[arr.length];

        for(int i = arr.length - 1; i >= 0; i--){
            System.out.println("st.size(): "+st.size()+ "\t"+"i: "+ i);
            if(st.size() > 0){
                //pop
                while((int)st.peek() < arr[i]){
                    st.pop();
                    if(st.size() == 0){
                        break;
                    }
                }

                //print ans
                if(st.size() > 0){
                arrA[i] = st.peek();
                } else {
                    arrA[i] = -1;
                }
               

                //push
                st.push(arr[i]);
            
           } else {
                arrA[i] = -1;

                 st.push(arr[i]);
           }
           System.out.println("stack: "+ st);

        }

        for(int i = 0; i< arrA.length; i++){
            System.out.print(arrA[i] + "\t");
        }
     }
}