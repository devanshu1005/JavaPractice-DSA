import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.*;

public class IteratorAndIterable{

    public static class GenericTree implements Iterable<Integer>{
        Node root;
        GenericTree(Node root){
            this.root = root;
        }

        public Iterator<Integer> iterator(){
            Iterator<Integer> obj = new GTPreOrderIterator(root);
            return obj;
        }
    }

    public static class GTPreOrderIterator implements Iterator<Integer>{
        Integer nval;
        Stack<Pair> st;

        public GTPreOrderIterator(Node root){
            st = new Stack<>();
            st.push(new Pair(root, -1));
            next();
        }

        public boolean hasNext(){
            if(nval == null){
                return false;
            } else {
                return true;
            }
        }

        public Integer next(){
            Integer fr = nval;

            nval = null;

            //moves nval forward if not possible sets it to null
            while(st.size()>0){
            Pair p = st.peek();
            if(p.state == -1){
                // pre = pre + p.node.data;
                nval = p.node.data;
                p.state++;
                break;
            } else if(p.state == p.node.children.size()){
                // post = post + st.pop().node.data;
                st.pop();
            } else {
                Pair toPush = new Pair(p.node.children.get(p.state), -1);
                st.push(toPush);
                p.state++;
                 
            }
        }


            return fr;
        }

    }

     public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node){
        String str = node.data + " --> ";
        for(Node child: node.children){
            str += child.data + " , ";
        }
        str += ".";
        System.out.println(str);
        for(Node child: node.children){
            display(child);
        }
    }

    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

   
     public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        // int[] arr = {10, 20, -1, 30, 50, -1, 60, -1,  -1,  40, -1};

        // int[] arr = {10, 20, -50, -1, -60, -1, -1, 30, -70, -1, 80, -110, -1, 120, -1, -1, 90, -1, -1, 40, -100, -1, -1, -1};
        Node root = null;

        Stack<Node> s = new Stack<>();

        for(int i= 0; i<arr.length; i++){
                if(arr[i] == -1){
                    s.pop();
                } else {
                    Node t = new Node();
                    t.data = arr[i];
                    if(s.size() == 0){
                        root = t;
                    } else {
                        s.peek().children.add(t);
                    }
                    s.push(t);
                }
        }
        
        GenericTree gt = new GenericTree(root);

        // for(int val: gt){
        //      System.out.println(val);
        // }

        Iterator<Integer> gti = gt.iterator();
        while(gti.hasNext()){
            System.out.println(gti.next());
        }
     }
}


                      