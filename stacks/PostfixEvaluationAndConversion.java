import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluationAndConversion{
    public static int solve(int b, int a, char ch){
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

    public static String solveInfixSt(String b, String a, String ch){
        return "(" + a + ch + b + ")";
    }

    public static String solvePrefixSt(String b, String a, String ch){
       return ch + a + b;
    }

     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // String str = scn.NextLine();
        String str = "264*8/+3-";

        Stack<Integer> st = new Stack <>();
        Stack<String> infixSt = new Stack <>();
        Stack<String> prefixSt = new Stack <>();

        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                st.push((int)str.charAt(i) - '0');
                infixSt.push(String.valueOf(str.charAt(i)));
                prefixSt.push(String.valueOf(str.charAt(i)));
            } else {
                st.push(solve(st.pop(), st.pop(), str.charAt(i)));
                infixSt.push(solveInfixSt(infixSt.pop(), infixSt.pop(), String.valueOf(str.charAt(i))));
                prefixSt.push(solvePrefixSt(prefixSt.pop(), prefixSt.pop(), String.valueOf(str.charAt(i))));
            }
        }

                System.out.println(st.peek());
                System.out.println(infixSt.peek());
                System.out.println(prefixSt.peek());
        
     }
}