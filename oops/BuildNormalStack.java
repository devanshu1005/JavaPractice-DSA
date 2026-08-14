import java.util.Scanner;

public class BuildNormalStack {

    int[] data;
    int tos;

    public BuildNormalStack(int capacity) {
        data = new int[capacity];
        tos = -1;
    }

    public void push(int val) {
         tos++;
         data[tos] = val;
    }

    public int pop() {
        int ans = data[tos];
        tos--;
        return ans;
    }

    public int top() {
        return data[tos];
    }

    public int size() {
        return tos+1;
    }

    public boolean isEmpty() {
        if(tos >= 0){
            return false;
        }else{
            return true;
        }
        
    }

    public void display() {
       for(int i = 0; i<= tos; i++){
        System.out.println(data[i]);
       }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int capacity = scn.nextInt();

        BuildNormalStack st = new BuildNormalStack(capacity);

        int q = scn.nextInt();

        for (int i = 0; i < q; i++) {

            int choice = scn.nextInt();

            if (choice == 1) {
                int val = scn.nextInt();
                st.push(val);
                System.out.println("choice == 1, st: " + st);

            } else if (choice == 2) {
                System.out.println(st.pop());
                System.out.println("choice == 2, st: " + st);

            } else if (choice == 3) {
                System.out.println(st.top());
                System.out.println("choice == 3, st: " + st);

            } else if (choice == 4) {
                System.out.println(st.size());
                System.out.println("choice == 4, st: " + st);

            } else if (choice == 5) {
                System.out.println(st.isEmpty());
                System.out.println("choice == 5, st: " + st);

            } else if (choice == 6) {
                st.display();
                System.out.println("choice == 6, st: " + st);
            }
        }
    }
}