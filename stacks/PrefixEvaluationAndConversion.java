import java.util.Scanner;
import java.util.Stack;

public class PrefixEvaluationAndConversion{
    public static int solve(int a, int b, char ch){
        if(ch == '+'){
            return a + b;
        }else if(ch == '-'){
            return a - b;
        }else if(ch == '*'){
            return a * b;
        } else {
            return a / b;
        }
    }

    public static String solveInfixSt(String a, String b, String ch){
        return "(" + a + ch + b + ")";
    }

    public static String solvePostfixSt(String b, String a, String ch){
       return b + a + ch;
    }

     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // String str = scn.NextLine();
        String str = "-+2/*6483";

        Stack<Integer> st = new Stack <>();
        Stack<String> infixSt = new Stack <>();
        Stack<String> postfixSt = new Stack <>();

        for(int i = str.length() - 1; i >= 0 ; i--){
            if(Character.isDigit(str.charAt(i))){
                st.push((int)str.charAt(i) - '0');
                infixSt.push(String.valueOf(str.charAt(i)));
                postfixSt.push(String.valueOf(str.charAt(i)));
            } else {
                st.push(solve(st.pop(), st.pop(), str.charAt(i)));
                infixSt.push(solveInfixSt(infixSt.pop(), infixSt.pop(), String.valueOf(str.charAt(i))));
                postfixSt.push(solvePostfixSt(postfixSt.pop(), postfixSt.pop(), String.valueOf(str.charAt(i))));
            }
        }

                System.out.println(st.peek());
                System.out.println(infixSt.peek());
                System.out.println(postfixSt.peek());
        
     }
}