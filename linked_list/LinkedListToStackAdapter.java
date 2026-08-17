import java.util.Scanner;

public class LinkedListToStackAdapter {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    int size;
    Node tail;

    public void push(int val) {
          Node temp = new Node(val);

        if(size == 0){
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
            size++;
    }

    public int pop() {
         if(size == 0){
        System.out.print("empty list");
        return -1;
    } else if(size == 1){
        Node temp = head;
        head = null;
        tail = null;
        size--;
        return temp.data;
    } else {
        Node temp = head;

        for(int i = 0; i < size - 2; i++){
            temp = temp.next;
        }

        Node ans = tail;
        tail = temp;
        temp.next = null;
        size--;
        return ans.data;
    }
    }

    public int top() {
        if(size == 0){
            System.out.println("List is empty");
            return -1;
        } else {
            return tail.data;
        }
    }

   public int size() {
        return size;
    }

    public boolean isEmpty() {
        if(size == 0){
            return true;
        } else {
            return false;
        }
    }

   public void display() {
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        LinkedListToStackAdapter st = new LinkedListToStackAdapter();

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