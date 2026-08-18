import java.util.Scanner;

public class OddEvenList {

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

     public void removeAt(int index){
        if(size == 0){
            System.out.println("empty list");
        } else if(index < 0 || index > size -1){
            System.out.println("invalid index");
        } else if(size == 1){
            head = null;
            tail = null;
            size = 0;
        } else if(index == 0){
            head = head.next;
            size--;
        } else if(index == size-1){
           removeLast();
        }
        else {
            Node temp = head;
            for(int i = 0; i< index - 1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }

    }

    // Approach 1

    // public static LinkedList oddEvenArrange(LinkedList list) {
    //     LinkedList res = new LinkedList();
    //    Node n = list.head;
    //    int i = 0;

    //     //remove odd
    //    while(n!= null){
    //     // System.out.println("i: " + i);
    //     if(n.data %2 == 0){
    //         n = n.next;
    //     i++;
    //     } else {
    //         int temp = n.data;
    //         n = n.next;
    //         list.removeAt(i);
    //         res.addLast(temp);
    //     }
    //    }
    // //    System.out.println("remove odd complete");

    //     //remove even
    //    n = list.head;
    //    i = 0;

    //    while(n!= null){
    //     int temp = n.data;
    //         n = n.next;
    //         list.removeAt(i);
    //         res.addLast(temp);
    //    }

       

    //     return res;

    // }

    //Approach 2

     public static LinkedList oddEvenArrange(LinkedList list) {
        LinkedList even = new LinkedList();
        LinkedList odd = new LinkedList();
       Node n = list.head;

       while(n!=null){
        int val = n.data;
        n = n.next;
        list.removeFirst();
        if(val%2 == 0){
            even.addLast(val);
        } else {
            odd.addLast(val);
        }
       }
a
       if(odd.size > 0 && even.size >0){
        list.head = odd.head;
        odd.tail.next = even.head;
        list.tail = even.tail;
    
       } else if (odd.size > 0){
         list.head = odd.head;
        list.tail = odd.tail;
       } else {
         list.head = even.head;
        list.tail = even.tail;
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

        LinkedList list = createList(scn);

        LinkedList oddEvenArranged = oddEvenArrange(list);

        oddEvenArranged.display();
    }
}