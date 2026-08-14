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
        return size;
    }

    public void display() {
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

    public int getFirst(){
        if(size == 0){
            System.out.println("List is empty");
            return -1;
        } else {
            return head.data;
        }
    }

    public int getLast(){
        if(size == 0){
            System.out.println("List is empty");
            return -1;
        } else {
            return tail.data;
        }
    }

    public int getAt(int index){
          if(size == 0){
            System.out.println("List is empty");
            return -1;
        } else if(index > size-1){
            System.out.println("Invalid Argument");
            return -1;
        } else if(index == 0){
                return head.data;
        } else {
                Node headTemp = new Node(0);
                headTemp.next = head.next;
                int i = 1;
               
             while(i < index){
                headTemp.next = headTemp.next.next;
                i++;
            }
            return headTemp.next.data;
        }
    }

    public void addFirst(int val){
            Node temp = new Node(val);
      if(size == 0){
            head = temp;
            head.next = temp;
      } else {
        temp.next = head;
        head = temp;
      }
            size++;
    }

    public void addAtIndex(int index, int val){
        Node temp = new Node(val);
        if(size == 0 && index == 0){
            head = temp;
            tail = temp;
            size++;
        }else if(index > size || index < 0){
            System.out.println("invalid argument");
        } else if(index == 0){
            temp.next = head;
            head = temp;
            size++;
        } else if(index == size){
            tail.next = temp;
            tail = temp;
            size++;
        } else {
            Node t = head;
            for(int i = 0; i<index - 1; i++){
                t = t.next;
            }
            temp.next = t.next;
            t.next = temp;
            size++;

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
            } else if (choice == 4) {

                list.removeFirst();
            } else if (choice == 5) {
                System.out.println(list.getFirst());
            } else if (choice == 6) {
                System.out.println(list.getLast());
            }else if (choice == 7) {
                int index = scn.nextInt();
                System.out.println(list.getAt(index));
            } else if (choice == 8) {
                int val = scn.nextInt();
                list.addFirst(val);
            } else if (choice == 9) {
                int index = scn.nextInt();
                int val = scn.nextInt();
                list.addAtIndex(index, val);
            } 
        }
    }
}