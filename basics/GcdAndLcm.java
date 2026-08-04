import java.util.Scanner;

public class GcdAndLcm {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
       int n1 = scn.nextInt();
       int n2 = scn.nextInt();
       int denominator = 1;
    int greater = n1;
    int smaller = n2;
    if(n2> n1){
        greater = n2;
        smaller = n1;
    }
       while(denominator != 0){
denominator = greater % smaller;
greater = smaller;
smaller = denominator;
       }

       System.out.println("GCD: "+ greater);

       int lcm = (n1 * n2)/greater;
        System.out.println("LCM: "+ lcm);
     }
}