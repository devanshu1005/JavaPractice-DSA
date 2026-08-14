import java.util.Scanner;

public class AddLastInLinkedList {

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

    public void addLast(int val) {
         Node temp = new Node(val);
            // temp.next = null;

        if(size == 0){
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
            size++;

    }

    public int size() {
        // TODO
        return size;
    }

    public void display() {
        // TODO
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void removeFirst(){
        if(size == 0){
                System.out.print("empty list");
        } else if(size == 1){
                head = null;
                tail = null;
                size--;
        } else {
                Node temp = head;
                head = temp.next;
                size--;
        }
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        AddLastInLinkedList list = new AddLastInLinkedList();

        int q = scn.nextInt();

        for (int i = 0; i < q; i++) {

            int choice = scn.nextInt();

            if (choice == 1) {

                int val = scn.nextInt();
                list.addLast(val);

            } else if (choice == 2) {

                System.out.println(list.size());

            } else if (choice == 3) {

                list.display();
            }
        }
    }
}