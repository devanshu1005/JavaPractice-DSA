import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.*;

public class PreAndPostOrderIterative{
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

    public static void preAndPosrOrder(Node node){
        Stack<Pair> st = new Stack<>();

        String pre = "";
        String post = "";
        st.push(new Pair(node, -1));

        while(st.size()>0){
            Pair p = st.peek();
            if(p.state == -1){
                pre = pre + p.node.data;
                p.state++;
            } else if(p.state == p.node.children.size()){
                post = post + st.pop().node.data;
            } else {
                Pair toPush = new Pair(p.node.children.get(p.state), -1);
                st.push(toPush);
                p.state++;
                 
            }
        }
      System.out.println(pre);
      System.out.println(post);
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
        
        
        preAndPosrOrder(root);

     

     }
}


                      