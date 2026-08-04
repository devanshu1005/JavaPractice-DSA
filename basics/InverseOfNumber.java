import java.util.Scanner;

//input === 15234
// op = 41235

//input === 2143
// op = 2143

//input === 426135
// op = 416253

public class InverseOfNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
       int index = 1;
       int sum = 0;
       while(n != 0){
        int dig = n%10; //2
        int multiplier = (int) Math.pow(10, dig - 1); //10
        multiplier = multiplier * index; //30
        sum = sum + multiplier; //1200
        n = n/10; //152
        index++; //3
       }
       System.out.println(sum);
     }
}