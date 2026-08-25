import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.*;

public class CeilAndFloor{
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

    public static int ceil;
    public static int floor;
    public static int state;
    
    public static void ceilAndFloor(Node node, int data){
        if(state == 0){
            if(node.data > data){
                state = 1;
                ceil = node.data;
            } else {
                floor = Math.max(floor, node.data);
            }
        } else if(state == 1){
            if(node.data > data && node.data < ceil){
                ceil = node.data;
            }

            if(node.data < data && node.data > floor){
                floor = node.data;
            }
        }
        for(Node child: node.children){
            ceilAndFloor(child, data);
        }
    }

    public static int kthLargest(Node node, int k){
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            ceilAndFloor(node, factor);
            factor = floor;
             floor = Integer.MIN_VALUE;
        }

        return factor;
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
        
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        state = 0;

        ceilAndFloor(root, 65);
       

        System.out.println("ceil: " + ceil);
        System.out.println("floor: " + floor);

         System.out.println(kthLargest(root, 3));

     }
}


                      