import java.util.Scanner;

public class PythagoreanTriplets{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();  //10
        int n2 = scn.nextInt(); //12
        int n3 = scn.nextInt(); //15

        int g = 0;
        int s1 = 0;
        int s2 = 0;

        if(n1 > g){
            g = n1;  //g = 10
            s1 = n2;
            s2 = n3;
        }

        if(n2 > g){
            g = n2;
            s1 = n1;
            s2 = n3;
        }

        if(n3 > g){
            g = n3;
            s1 = n1;
            s2 = n2;
        }

        System.out.println("greatest: "+g);
        System.out.println("small1: "+s1);
        System.out.println("small2: "+s2);

        if( ((s1*s1) + (s2 * s2)) == (g * g)){
            System.out.println("It is a Pythagorous right angle traingle");
        } else {
             System.out.println("It is not a Pythagorous right angle traingle");
        }
     }
}