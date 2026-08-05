import java.util.Scanner;

public class DecimalToAnyBase{
    public static int convert(int num, int base){
            int ans = 0;
            int count = 0;
            while( num != 0){
            int rem = num % base;
            rem = rem * (int) Math.pow(10, count);
            ans = ans + rem;
            num = num / base;
            count++;
            }
            return ans;
    }

     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();
        int base = scn.nextInt();
        System.out.println(convert(num, base));
     }
}