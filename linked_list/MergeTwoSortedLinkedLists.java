import java.util.Scanner;

public class MergeTwoSortedLinkedLists {

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
    }

    public static LinkedList mergeTwoLists(LinkedList l1, LinkedList l2) {
        int ans = 0;
        Node i1 = l1.head;
        Node i2 = l2.head;
         LinkedList list = new LinkedList();

        while(i1 != null && i2 != null){
            if(i1.data > i2.data){
                ans = i2.data;
                i2 = i2.next;
            } else if (i1.data == i2.data){
                ans = i1.data;
                i1 = i1.next;
                i2 = i2.next;
            } else {
                ans = i1.data;
                i1 = i1.next;
            }
            list.addLast(ans);
        }

        while(i1 != null || i2 != null){
            if(i1 == null){
                ans = i2.data;
                i2 = i2.next;
            } else {
                ans = i1.data;
                i1 = i1.next;
            }
            list.addLast(ans);
        }
        return list;
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

        LinkedList l1 = createList(scn);
        LinkedList l2 = createList(scn);

        LinkedList merged = mergeTwoLists(l1, l2);

        merged.display();
    }
}