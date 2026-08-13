import java.util.Scanner;

public class BuildDynamicStack {

    int[] data;
    int tos;

    public BuildDynamicStack(int capacity) {
        data = new int[capacity];
        tos = -1;
    }

    public void push(int val) {
        if(tos == data.length - 1){
            int data2[] = new int[data.length];
            data2 = data;
            data = new int[2 * data.length];
            for(int i = 0; i <= tos; i++){
                data[i] = data2[i];
            }
            tos++;
            data[tos] = val;
        } else {
            tos++;
         data[tos] = val;
        }
        
    }

     public int pop() {
        // TODO
        if(tos == -1){
            System.out.print("Stack underflow");
            return -1;
        } else {
        int ans = data[tos];
        tos--;
        return ans;
        }
      
    }

    public int top() {
        // TODO
        return data[tos];
    }

    public int size() {
        // TODO
        return tos+1;
    }

    public boolean isEmpty() {
        // TODO
        if(tos >= 0){
            return false;
        }else{
            return true;
        }
        
    }

    public void display() {
       for(int i = 0; i<= tos; i++){
        System.out.print(data[i]);
       }
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int capacity = scn.nextInt();

        BuildDynamicStack st = new BuildDynamicStack(capacity);

        int q = scn.nextInt();

        for (int i = 0; i < q; i++) {

            int choice = scn.nextInt();

            if (choice == 1) {

                int val = scn.nextInt();
                st.push(val);

            } else if (choice == 2) {

                System.out.println(st.pop());

            } else if (choice == 3) {

                System.out.println(st.top());

            } else if (choice == 4) {

                System.out.println(st.size());

            } else if (choice == 5) {

                System.out.println(st.isEmpty());

            } else if (choice == 6) {

                st.display();
            }
        }
    }
}