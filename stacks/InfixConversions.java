import java.util.Scanner;
import java.util.Stack;

public class InfixConversions{

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

    public static String solve(String a, String b, char ch){
       return ch + a + b;
    }

    public static String solvePost(String a, String b, char ch){
       return a + b + ch;
    }

     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
           Stack<String> st = new Stack <>();
           Stack<String> stPost = new Stack <>();
           Stack<Character> operator = new Stack <>();
        //    String str = scn.nextLine();
        //    String str = "2+(5-3*6/2)";
           String str = "a*(b-c)/d+e";

           for(int i = 0; i < str.length(); i++){
            // if(Character.isDigit(str.charAt(i))){
            if((str.charAt(i) >= '0' && str.charAt(i) <= '9') || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')){
                   st.push(String.valueOf(str.charAt(i)));
                   stPost.push(String.valueOf(str.charAt(i)));
             } else if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/'){
                    while(operator.size() > 0 && precedence(operator.peek()) >= precedence(str.charAt(i)) ){
                        String var2 = st.pop();
                        String var1 = st.pop();
                        char ch = operator.pop();
                        String res = solve(var1, var2, ch);
                        st.push(res);

                        String var2Post = stPost.pop();
                        String var1Post = stPost.pop();
                        String resPost = solvePost(var1Post, var2Post, ch);
                        stPost.push(resPost);
                        //  System.out.println(st);
                        // System.out.println(stPost);
                    }
                    operator.push(str.charAt(i));
             } else if(str.charAt(i) == ')'){
                    while(operator.peek() != '('){
                        String var2 = st.pop();
                        String var1 = st.pop();
                        char ch = operator.pop();
                        String res = solve(var1, var2, ch);
                        st.push(res);

                        String var2Post = stPost.pop();
                        String var1Post = stPost.pop();
                        String resPost = solvePost(var1Post, var2Post, ch);
                        stPost.push(resPost);
                        // System.out.println(str.charAt(i));
                        // System.out.println(st);
                        // System.out.println(stPost);
                    }
                    operator.pop();
             }else{
                        // System.out.println(str.charAt(i));
                   operator.push(str.charAt(i));

             }
           }

            while(operator.size() > 0){
            String var2 = st.pop();
                        String var1 = st.pop();
                        char ch = operator.pop();
                        String res = solve(var1, var2, ch);
                        st.push(res);

                        String var2Post = stPost.pop();
                        String var1Post = stPost.pop();
                        String resPost = solvePost(var1Post, var2Post, ch);
                        stPost.push(resPost);
            }
           System.out.println(st.peek());
           System.out.println(stPost.peek());
     }
}