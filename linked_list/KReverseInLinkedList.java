import java.util.Scanner;

public class KReverseInLinkedList {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public void addLast(int val) {
            Node temp = new Node(val);

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public void display() {
            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }

            System.out.println();
        }

        public int getFirst(){
        if(size == 0){
            System.out.println("List is empty");
            return -1;
        } else {
            return head.data;
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

   public void addFirst(int val) {

    Node temp = new Node(val);

    if(size == 0) {
        head = tail = temp;
    } else {
        temp.next = head;
        head = temp;
    }

    size++;
}

      public void removeLast(){
    if(size == 0){
        System.out.print("empty list");
    } else if(size == 1){
        head = null;
        tail = null;
        size--;
    } else {
        Node temp = head;

        for(int i = 0; i < size - 2; i++){
            temp = temp.next;
        }

        tail = temp;
        temp.next = null;
        size--;
    }
    }

    

    }


    public static LinkedList reverse(LinkedList list, int k) {

    LinkedList prev = new LinkedList();
    LinkedList curr = new LinkedList();

    int less = list.size % k;

    while(list.size > less) {

        int val = list.getFirst();
        list.removeFirst();

        curr.addFirst(val);

        if(curr.size == k) {

            if(prev.size == 0) {
                prev.head = curr.head;
                prev.tail = curr.tail;
            } else {
                prev.tail.next = curr.head;
                prev.tail = curr.tail;
            }

            prev.size += k;

            curr.head = null;
            curr.tail = null;
            curr.size = 0;
        }
    }

    while(list.size > 0) {

        int val = list.getFirst();
        list.removeFirst();

        prev.addLast(val);
    }

    return prev;
}

    public static LinkedList createList(Scanner scn) {

        LinkedList list = new LinkedList();

        int n = scn.nextInt();

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            list.addLast(val);
        }

        return list;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        LinkedList list = createList(scn);

         int k = scn.nextInt();

        LinkedList reversed = reverse(list, k);

        reversed.display();
    }
}