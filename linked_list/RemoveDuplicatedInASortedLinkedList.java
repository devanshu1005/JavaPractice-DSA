import java.util.Scanner;
import java.util.Stack;

public class RemoveDuplicatedInASortedLinkedList {

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

    }

    public static LinkedList removeDuplicates(LinkedList list) {
        //Approach 1

        // Stack<Integer> st = new Stack <>();
        // Node temp = list.head;
        // while(temp != null){
        //     if(st.size() == 0){
        //         st.push(temp.data);
        //         temp = temp.next;
        //     } else {
        //         if(st.peek() == temp.data){
        //             temp = temp.next;
        //         } else {
        //             st.push(temp.data);
        //             temp = temp.next;
        //         }
        //     }
        // }

        // System.out.println("stack st1: " + st);

        // temp = list.head;
        // Stack<Integer> st2 = new Stack <>();
        // int i = 0;

        // while(st.size() != 0){
        //     st2.push(st.pop());
        // }

        // System.out.println("stack st2: " + st2);

        //   while(st2.size() != 0){
        //    temp.data = st2.pop();
        //     list.tail = temp;
        //     temp = temp.next;
        //     i++;
        // }
        // list.tail.next = null;
        // list.size = i;



        //Approach 2

        // if(list.size > 1){
        //     Node s = list.head;
        //     Node f = list.head.next;
        //     list.size = 1;

        //     while(f != null){
        //         if(s.data == f.data){
        //             f = f.next;
        //         } else {
        //             s.next = f;
        //             s = f;
        //             f = f.next;
        //             list.size++;
        //         }
        //     }
        //     s.next = null;
        //     list.tail = s;
        //     return list;
        // } else {
        //      return list;
        // }


        //Approach 3
        LinkedList res = new LinkedList();
         System.out.println("Size1: " +res.size);
        while(list.size > 0){
        System.out.println("Size2: " +res.size);
       
            int val = list.getFirst();
            list.removeFirst();

            if(res.size == 0){
                      res.addLast(val);
            } else if(res.tail.data != val){
                      res.addLast(val);
            }

        System.out.println("Size4: " +res.size);

        }

        System.out.println("Size3: " +res.size);
        System.out.println("head: " +res.head.data);
        System.out.println("tail: " +res.tail.data);

       return res;
       
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

        LinkedList duplicatesRemoved = removeDuplicates(list);

        duplicatesRemoved.display();
    }
}