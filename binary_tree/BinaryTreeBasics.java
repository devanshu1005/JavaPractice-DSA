import java.util.*;

public class BinaryTreeBasics{

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
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

    // public static int size;
    // public static int sum;
    // public static int max;
    // public static int height;

    public static void display(Node node){
        if(node == null){
            return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.data + " ";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + " ";

       System.out.println(str);

        display(node.left);
        display(node.right);
    }

    // public static void multiSolver(Node node, int floor){
    //     if(node == null){
    //         return;
    //     }
    //     size++;
    //     sum = sum + node.data;
    //     max = Math.max(max, node.data);
    //     height = height + floor;

    //     multiSolver(node.left, 1);
    //     multiSolver(node.right, 0);

    // }

    public static int size(Node node){
         if(node == null){
            return 0;
        }

        int ch1 = size(node.left);
        int ch2 = size(node.right);

        return  ch1 + ch2 + 1;
    }

     public static int sum(Node node){
         if(node == null){
            return 0;
        }

        int s1 = sum(node.left);
        int s2 = sum(node.right);

        return  s1 + s2 + node.data;
    }

     public static int max(Node node){
         if(node == null){
            return Integer.MIN_VALUE;
        }

        int max = node.data;
        int m1 = max(node.left);
        max = Math.max(max, m1);
        int m2 = max(node.right);
        max = Math.max(max, m2);

        return  max;
    }

     public static int height(Node node){
         if(node == null){
            return -1;
        }

        int height = -1;

        int h1 = height(node.left);
        int h2 = height(node.right);

        int l = Math.max(h1, h2);
        height = Math.max(height, l);

        return height + 1;
    }

    public static void main(String[] args) throws Exception{
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};

        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();

        st.push(rtp);

        int idx = 0;

        while(st.size()>0){
            Pair top = st.peek();

            if(top.state == 1){
                idx++;
                if(arr[idx] != null){
                    Node ln = new Node(arr[idx], null, null);
                    top.node.left = ln;

                    Pair lp = new Pair(ln, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if(top.state ==2){
                  idx++;
                if(arr[idx] != null){
                    Node rn = new Node(arr[idx], null, null);
                    top.node.right = rn;

                    Pair rp = new Pair(rn, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                st.pop();
            }
        }

        // display(root);

        // size = 0;
        // height = 0;
        // sum = 0;
        // max = Integer.MIN_VALUE;

        // multiSolver(root, 0);
        // System.out.println("size: " + size);
        // System.out.println("sum: " + sum);
        // System.out.println("max: " + max);
        // System.out.println("height: " + height);

       int size = size(root);
        System.out.println("size: " + size);

        int sum = sum(root);
        System.out.println("sum: " + sum);

        int max = max(root);
        System.out.println("max: " + max);

         int height = height(root);
        System.out.println("height: " + height);
    }
}