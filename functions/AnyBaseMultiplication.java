import java.util.Scanner;

public class AnyBaseMultiplication{

    public static int multiply(int num1, int num2, int base){ 
        int ans = 0;
        int multiplier = 1;
        // int val = 0;

        //num1 =  111     num2 =  22     dig = 2   base = 8     tempNum = 11     tempDig= 1      tempSum = 0
        //tempCarry = 0     tempMultiplier = 10;     tempAns = 2;       product =  2      multiplier = 1;

    while(num2 != 0){
        int dig = num2 % 10;
       int tempNum = num1;
       int tempSum = 0;
       int tempAns = 0;
       int tempCarry = 0;
       int tempMultiplier = 1;
        while(tempNum != 0){
           int tempDig = tempNum % 10;
            int product = dig * tempDig + tempCarry;
            if(product >= base){
                tempSum = product % base;
                tempCarry = product / base;
                tempAns = tempAns + (tempSum * tempMultiplier);
                
            } else {
                tempAns = tempAns + (product * tempMultiplier);
                tempCarry = 0;
            }
            tempNum = tempNum/10;
            tempMultiplier *= 10;
        }
        if(tempCarry != 0){
         tempAns = tempAns + (   tempCarry * tempMultiplier);
        }
        tempAns = tempAns * multiplier;
        multiplier *= 10;
        num2 = num2/10;
        System.out.println("tempAns: " + tempAns);
        // addition logic
       ans = add(ans, tempAns ,base);

        
    }
       return ans;
    }

     public static int add(int num1, int num2, int base){ 
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
        System.out.println(multiply(num1, num2, base));
     }
}