import java.util.Scanner;

//TODO: complete queue topic incomplete

public class BuildNormalQueue {

    int[] data;
    int pos;
    int removeIndex;
    // int front;
    // int rear;
    // int size;

    public BuildNormalQueue(int capacity) {
        data = new int[capacity];
        pos = 0;
        removeIndex = 0;
        // front = 0;
        // rear = 0;
        // size = 0;
    }

    public void add(int val) {
        // TODO
        if(pos > (data.length -1)){
            int i = pos % data.length;
            if(data[i] != -1){
                    System.out.println("stack overflow");
            }else {
                data[i] = val;
                pos++;
            }
            
        } else {
            data[pos] = val;
            pos++;
        }
       
    }

    public int remove() {
        // TODO
         if(removeIndex > (data.length -1)){
            int i = removeIndex % data.length;
            if(data[i] != -1){
                int ans = data[i];
                data[i] = -1;
                removeIndex++;
                return ans;
            }else {
                    System.out.println("stack underflow");
                    return -1;
            }
            
        } else {
            int ans = data[removeIndex];
            data[removeIndex] = -1;
            removeIndex++;
            return ans;
        }
        
    }

    public int peek() {
        // TODO
        return -1;
    }

    public int size() {
        // TODO
        return 0;
    }

    public boolean isEmpty() {
        // TODO
        return false;
    }

    public void display() {
        // TODO
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int capacity = scn.nextInt();

        BuildNormalQueue qu = new BuildNormalQueue(capacity);

        int q = scn.nextInt();

        for (int i = 0; i < q; i++) {

            int choice = scn.nextInt();

            if (choice == 1) {

                int val = scn.nextInt();
                qu.add(val);

            } else if (choice == 2) {

                System.out.println(qu.remove());

            } else if (choice == 3) {

                System.out.println(qu.peek());

            } else if (choice == 4) {

                System.out.println(qu.size());

            } else if (choice == 5) {

                System.out.println(qu.isEmpty());

            } else if (choice == 6) {

                qu.display();
            }
        }
    }
}