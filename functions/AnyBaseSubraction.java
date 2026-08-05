import java.util.Scanner;

public class AnyBaseSubraction{

    public static int sub(int num1, int num2, int base){ 

// num1 =  12     num2 = 45    base =  8    ans = 33     carry = 0       multiplier = 10;     sub = 
//dig2 = 5    dig1 = 2

        int ans = 0;
        int carry = 0;
        int multiplier = 1;
        while(num2 != 0){
          int  dig2 = (num2 % 10) + carry;
           int dig1 = num1 % 10;
            if(dig2 < dig1){
                dig2 = dig2 + base;
                carry = -1;
                int sub = (dig2 - dig1) * multiplier;
                ans = ans + sub;
            } else {
                ans = ans + ((dig2 - dig1) * multiplier);
                carry = 0;
            }
            num2 = num2/10;
            num1 = num1/10;
            multiplier*= 10;

        }

       return ans;
    }
 

     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int num1 = scn.nextInt();
        int num2 = scn.nextInt();
        int base = scn.nextInt();
        System.out.println(sub(num1, num2, base));
     }
}