import java.util.Scanner;

public class AnyBaseAddition{

    public static int add(int num1, int num2, int base){ //base = 8     miltiplier = 1      ans = 0

 //  carry =        dig1 =         dig2 =          sum=       num1= 777         num2 = 1          rem = 
            int multiplier = 1;
            int ans = 0;
            int carry = 0;

        while(num1 != 0 || num2 !=0){
        int dig1 = num1 % 10;
        int dig2 = num2 % 10;
        int rem = 0;
        int sum = dig1 + dig2 + carry;
        if(sum >= base){
             rem = sum % base;
            rem = rem * multiplier;
            ans = ans + rem;
             carry = sum / base;
        } else {
            sum = sum * multiplier;
            ans = ans + sum;
            carry = 0;
        }
        num1 = num1/10;
        num2 = num2/10;
        multiplier *=10;
        }

            ans = ans + (carry * multiplier);

       return ans;
    }
 

     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int num1 = scn.nextInt();
        int num2 = scn.nextInt();
        int base = scn.nextInt();
        System.out.println(add(num1, num2, base));
     }
}