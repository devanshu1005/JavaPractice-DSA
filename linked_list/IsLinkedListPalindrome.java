import java.util.Scanner;

public class IsLinkedListPalindrome {
    static Node left;
    static boolean isPalindrome;

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

   public static void reverse(Node node, int floor, int size) {
    if(node == null){
        return;
    }

     reverse(node.next,  floor + 1, size);

     if(floor > size/2){
    // int temp = node.data;
    //  node.data = left.data;
    //  left.data = temp;
    if(node.data == left.data){
        //
    } else {
        isPalindrome = false;
    }

     left = left.next;
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

        LinkedList list = createList(scn);

      left = list.head;

      isPalindrome = true;

        reverse(list.head, 1, list.size);

        if(isPalindrome){
            System.out.println("yes it is palindrome");
        } else {
            System.out.println("no it is not a palindrome");

        }

        // list.display();
    }
}