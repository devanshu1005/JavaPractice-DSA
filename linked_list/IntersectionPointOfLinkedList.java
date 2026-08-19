import java.util.Scanner;

//TODO: approach 2

public class IntersectionPointOfLinkedList {

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

          public int findMergingPoint(Node head1, Node head2) {
            if(head1 == null){
                return 0;
            }

            int mergingPoint = findMergingPoint(head1.next, head2.next);
            
            if(mergingPoint == 0){
                if(head1.next == head2.next){
                    return 0;
                } else {
                   return head1.next.data;
                }
            }else{
                return mergingPoint;
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


        LinkedList list1 = createList(scn);
        LinkedList list2 = createList(scn);


        if(list1.size > list2.size){
           int diff = list1.size - list2.size;
            if(diff != 0){
            for(int i=1; i<=diff; i++){
                list2.addFirst(0);
            }
        }
        } else {
           int diff = list2.size - list1.size;
           if(diff != 0){
            for(int i=1; i<=diff; i++){
                list1.addFirst(0);
            }
        }
        }


       int mergingPoint = list1.findMergingPoint(list1.head, list2.head);

       System.out.println("list is merging at point: " + mergingPoint);
       

        // list2.display();
       

    }
}