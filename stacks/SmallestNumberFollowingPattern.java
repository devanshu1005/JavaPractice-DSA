import java.util.Scanner;
import java.util.Stack;


public class SmallestNumberFollowingPattern {
    public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
       String str = scn.nextLine();
       Stack<Character> st = new Stack <>();

       int z1 = 0;
       int z2 = 0;

       for(int i = 0; i<str.length(); i++){
        if(str.charAt(i) == 'd' || str.charAt(i) == 'D'){
                st.push(str.charAt(i));
        } else {
                st.push(str.charAt(i));
            while(st.size() > 0){
                st.pop();
                z2++;
            }
        }
        if(z2 > z1){
           int temp = z2;
            for(int j = z1; j<z2; j++){
                System.out.print(temp);
                temp--;
            }
            z1 = z2;
        }
       }
        while(st.size() > 0){
                st.pop();
                z2++;
            }
            z2++;
        // System.out.println();
        // System.out.println(z1);
        // System.out.println(z2);
        if(z2 > z1){
           int temp = z2;
            for(int j = z1; j<z2; j++){
                System.out.print(temp);
                temp--;
            }
        }
    }
}