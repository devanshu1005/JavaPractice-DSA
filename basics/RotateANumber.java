import java.util.Scanner;

public class RotateANumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int nod = 0;
        int tempN = n;

        //number of digits
        while(tempN != 0){
            nod++;
            tempN = tempN /10;
        }

        if(k < 0){
            while(k < 0){
            k = nod + k;
            }
            
        }

        if(k > nod){
            while(k > nod){
            k = k - nod;
            }
        }

        if(k == nod){
             System.out.println(n);
        } else {
        int value1 = (n%((int) Math.pow(10, k))) * (int) Math.pow(10, nod - k);
        int value2 = n / (int) Math.pow(10, k);
        int finalValue = value1 + value2;
        System.out.println(finalValue);
        }
     }
}