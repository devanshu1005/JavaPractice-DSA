import java.util.Scanner;

//important

//TODO: Approach 2

public class AddTwoLinkedLists {

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
        // int iteration;

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

         public int addTwoLinkedLists(Node head1, Node head2, int floor, int size1, int size2) {
            // iteration++;
            if(head1 == null){
                return 0;
            }
            
            int carry = 0;
            if(floor < (size1 - size2 ) ){
             carry = addTwoLinkedLists(head1.next, head2, floor + 1, size1, size2);
            } else {
                 carry = addTwoLinkedLists(head1.next, head2.next, floor + 1, size1, size2);
            }

            
            int sum = 0;
    if(floor >= size1 - size2){
                 sum = head1.data + head2.data + carry;
            } else {
                 sum = head1.data + carry;
            }
            carry = sum/10;
            head1.data = sum%10;
            return carry;
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

        if(list1.size> list2.size){
           int carry = list1.addTwoLinkedLists(list1.head, list2.head, 0, list1.size, list2.size);
             if(carry != 0){
            list1.addFirst(carry);
            }
        list1.display();

        } else {
           int carry = list2.addTwoLinkedLists(list2.head, list1.head, 0, list2.size, list1.size);
            if(carry != 0){
            list2.addFirst(carry);
            
            }
        list2.display();

        } 

       

    }
}