import java.util.Scanner;

// n = 95439692

public class DigitFrequency {
    public static int checkFrequency(int a, int b){
       int count = 0;
        while(a>0){
            int dig = a%10;
            if(dig == b){
                count++;
            }
            a = a/10;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
       int n1 = scn.nextInt();
       int n2 = scn.nextInt();
       int frequency = checkFrequency(n1, n2);
       System.out.println(frequency);
     }
}