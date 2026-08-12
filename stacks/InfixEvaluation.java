import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation{

    public static int precedence(char ch){
        if(ch == '+'){
            return 1;
        }else if(ch == '-'){
            return 1;
        }else if(ch == '*'){
            return 2;
        } else if (ch == '/'){
            return 2;
        } else {
            return 0;
        }
    }

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
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
           Stack<Integer> st = new Stack <>();
           Stack<Character> operator = new Stack <>();
        //    String str = scn.nextLine();
           String str = "2+(5-3*6/2)";

           for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                    st.push((int)str.charAt(i) - '0');
             } else if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/'){
                    while(operator.size() > 0 && precedence(operator.peek()) >= precedence(str.charAt(i)) ){
                        int var2 = st.pop();
                        int var1 = st.pop();
                        char ch = operator.pop();
                        int res = solve(var1, var2, ch);
                        st.push(res);
                    }
                    operator.push(str.charAt(i));
             } else if(str.charAt(i) == ')'){
                    while(operator.peek() != '('){
                        int var2 = st.pop();
                        int var1 = st.pop();
                        char ch = operator.pop();
                        int res = solve(var1, var2, ch);
                        st.push(res);
                        // System.out.println(str.charAt(i));
                        // System.out.println(operator);
                    }
                    operator.pop();
             }else{
                        // System.out.println(str.charAt(i));
                   operator.push(str.charAt(i));

             }
           }

            while(operator.size() > 0){
                 int var2 = st.pop();
                 int var1 = st.pop();
                 char ch = operator.pop();
                 int res = solve(var1, var2, ch);
                 st.push(res);
            }
           System.out.println(st.peek());
     }
}