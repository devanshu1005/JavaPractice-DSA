import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // int n = scn.nextInt(); // rows & columns

        // int[][] arr = new int[n][n];

         // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         arr[i][j] = scn.nextInt();
        //     }
        // }

        //approach 1 (it may time o(n square in worst))

        // int n = 5;
        // int ans = 0;
        // boolean isCelebrity = false;

        // int[][] arr = {
        //                  {0, 1, 1, 1, 1},
        //                  {1, 0, 0, 1, 0},
        //                  {1, 0, 0, 1, 0},
        //                  {0, 0, 0, 0, 0},
        //                  {0, 1, 0, 1, 0}
        //                 };


        // for(int i = 0; i < n; i++){
        // int counter = 0;
        //     int j = 0;
        //     while(j<n && arr[i][j] != 1){
        //         j++;
        //     }
        //     if(j == n){
        //         int k = 0;
        //         while(k < n){
        //             if(k!=i && arr[k][i] == 1){
        //                counter++;
        //             }
        //             k++;
        //         }
        //         if(counter == n-1){
        //             isCelebrity = true;
        //             ans = i;
        //             break;
        //         }
        //     }
        // }

        // if(isCelebrity){
        //         System.out.println("Celebrity is: " +ans);
        // } else {
        //         System.out.println("No celebrity found");

        // }

         //approach 2 (efficient approach)

        int n = 5;
        int ans = 0;
        boolean isCelebrity = true;

        int[][] arr = {
                         {0, 1, 1, 1, 1},
                         {1, 0, 0, 1, 0},
                         {1, 0, 0, 1, 0},
                         {0, 0, 0, 0, 0},
                         {0, 1, 0, 1, 0}
                        };

        Stack<Integer> st = new Stack <>();

                        for(int i = 0; i<n; i++){
                            st.push(i);
                        }

                        while(st.size() > 1){
                            int b = st.pop();
                            int a = st.pop();
                            if(arr[a][b] == 0){
                                st.push(a);
                            } else {
                                st.push(b);
                            }
                        }

                         System.out.println(st);

        int k = 0;

        while(k<n){
            if(arr[st.peek()][k] == 0){
                k++;
            } else {
                isCelebrity = false;
                break;
            }
        }
         
         if(isCelebrity == false){
             System.out.println("No celebrity found");
             return;
         } else {
            k = 0;
         }

         while(k<n){
             if(k != st.peek() && arr[k][st.peek()] == 1){
                k++;
            } else if(k == st.peek()){
                k++;
            } else {
                isCelebrity = false;
                break;
            }
         }

          if(isCelebrity == false){
             System.out.println("No celebrity found");
         } else {
            System.out.println("celebrity is: " + st.peek());
         }

    }
}