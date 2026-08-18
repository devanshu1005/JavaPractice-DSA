import java.util.Scanner;

//important

public class MergeSortLinkedList {

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

        public Node getNodeAt(int index) {
            Node temp = head;

            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }

            return temp;
        }
    }

    // You have to implement this method
    public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
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

    // You have to implement this method
    public static Node midNode(Node head, Node tail) {
        Node s = head;
        Node f = head;

        while(f != tail && f.next !=tail){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    // You have to implement this method
    public static LinkedList mergeSort(Node head, Node tail) {
        if(head == tail){
             LinkedList list = new LinkedList();
             list.addLast(head.data);
             return list;
        }

        Node m = midNode(head, tail);
        LinkedList fh = mergeSort(head, m);
        LinkedList sh = mergeSort(m.next, tail);


        LinkedList ans = mergeTwoSortedLists(fh, sh);
        return ans;
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

        LinkedList sorted = mergeSort(list.head, list.tail);

        sorted.display();
    }
}