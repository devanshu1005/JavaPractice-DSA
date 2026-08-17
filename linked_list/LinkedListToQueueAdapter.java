import java.util.Scanner;

public class LinkedListToQueueAdapter {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int size;

    public void add(int val) {
          Node temp = new Node(val);

        if(size == 0){
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
            size++;
    }

    public int remove() {
          if(size == 0){
                System.out.print("empty list");
                 return -1;
        } else if(size == 1){
            Node ans = head;
                head = null;
                tail = null;
                size--;
                return ans.data;
        } else {
                Node temp = head;
                head = temp.next;
                size--;
                return temp.data;
        }
       
    }

    public int peek() {
          if(size == 0){
            System.out.println("List is empty");
            return -1;
        } else {
            return head.data;
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

        LinkedListToQueueAdapter queue = new LinkedListToQueueAdapter();

        int q = scn.nextInt();

        for (int i = 0; i < q; i++) {

            int choice = scn.nextInt();

            if (choice == 1) {

                int val = scn.nextInt();
                queue.add(val);

            } else if (choice == 2) {

                System.out.println(queue.remove());

            } else if (choice == 3) {

                System.out.println(queue.peek());

            } else if (choice == 4) {

                System.out.println(queue.size());

            } else if (choice == 5) {

                System.out.println(queue.isEmpty());

            } else if (choice == 6) {

                queue.display();
            }
        }
    }
}