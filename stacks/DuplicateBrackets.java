import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets{
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        Stack<Character> st = new Stack<>();
        boolean isDuplicate = false;

        for(int i = 0; i < str.length(); i++){
            // System.out.println(str.charAt(i));
            // if(i > 1){
            if(str.charAt(i) == ')' && (char)st.peek() == '('){        // i = 1
                                                //  ((
                isDuplicate = true;
                break;
            }
            // }
           
            if(str.charAt(i) != ')'){
                st.push(str.charAt(i));
            } else {
                while((char)st.peek() != '('){
                    st.pop();
                }
                    st.pop();
            }
        }
        System.out.println(isDuplicate);
     }
}