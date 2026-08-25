import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.*;

public class MultiSolver{
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

    static int max;
    static int min;
    static int size;
    static int height;

    static Node predecessor;
    static Node sucessor;
    static int state;

    public static void multisolver(Node node, int depth){
        size++;
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        height = Math.max(height, depth);
        for(Node child: node.children){
            multisolver(child, depth + 1);
        }
        return;
    }

    public static void predecessorAndSucessor(Node node, int data){
        if(state == 0){
            if(node.data == data){
                state = 1;
            } else {
                predecessor = node;
            }
        } else if (state == 1){
                sucessor = node;
                state = 2;
        }
        for(Node child: node.children){
            predecessorAndSucessor(child, data);
        }
    }


     public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        // int[] arr = {10, 20, -1, 30, 50, -1, 60, -1,  -1,  40, -1};
        Node root = null;

        Stack<Node> st = new Stack<>();

        for(int i= 0; i<arr.length; i++){
                if(arr[i] == -1){
                    st.pop();
                } else {
                    Node t = new Node();
                    t.data = arr[i];
                    if(st.size() == 0){
                        root = t;
                    } else {
                        st.peek().children.add(t);
                    }
                    st.push(t);
                }
        }
        
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        size = 0;
        height = 0;

        multisolver(root, 0);
        
        // System.out.println("Min: " + min);
        // System.out.println("Max: " + max);
        // System.out.println("size: " + size);
        // System.out.println("height: " + height);

        predecessor = null;
        sucessor = null;
        state = 0;
        
        predecessorAndSucessor(root, 50);

        System.out.println("Predecessor: " + predecessor.data);
        System.out.println("sucessor: " + sucessor.data);

     }
}


                      