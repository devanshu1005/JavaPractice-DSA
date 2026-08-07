import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets{
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        Stack<Character> st = new Stack<>();
        boolean isBalanced = true;

// [ +         }                  

        for(int i = 0; i < str.length(); i++){ 
            // System.out.println("str.charAt(i): " + str.charAt(i));
            //  System.out.println("stack ->: " + st + " st length: " + st.size());
            if(str.charAt(i) != ')' && str.charAt(i) != '}' && str.charAt(i) != ']'){
                    st.push(str.charAt(i));
               
            } else {
                 while(((char)st.peek() != '(' ) && ((char)st.peek() != '{' ) && ((char)st.peek() != '[')){
                        st.pop();
                }
                if((st.peek() == '(' && str.charAt(i) == ')') || (st.peek() == '{' && str.charAt(i) == '}') || (st.peek() == '[' && str.charAt(i) == ']')){
                    st.pop();
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if(st.size() != 0){
            isBalanced = false;
        }
        System.out.println(isBalanced);
     }
}