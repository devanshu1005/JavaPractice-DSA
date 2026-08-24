import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.*;

                         //                             D
                        //                             /\
                        //            Personal                  pepcoding
                        //              /|\                         /|\
                        //   movies    songs      tax      course  Accounts    documents

                        //   Parent - d is parent of personal
                        //   child - personal is child of d
                        //   ancestor -- for movies,  personal and d are ancestors
                        //   descendent -- for d all of them, for pepcoding course accounts and documents
                        //   root -- d (where tree starts)

public class GenericTreeBasics{
     public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

        // Node(){

        // }

        // Node(int data){
        //     this.data = data;
        // }
    }

    private static class Pair{
        Node node;
        int level;

        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
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

    public static int size(Node node){
        int size = 0;
        for(Node child: node.children){
           int cs = size(child);
            size = cs + size;
        }
        size++;
        return size;
    }

    public static int max(Node node){
        int max = Integer.MIN_VALUE;

        for(Node child: node.children){
            int cm = max(child);
             max = (int)Math.max(max, cm);
        }

         max = Math.max(node.data, max);
         return max;

    }

     public static int height(Node node){
        int height = -1;

       for(Node child: node.children){
         int ch = height(child);
         height = (int)Math.max(ch, height);
       }

       height +=1;
       return height;

    }

    public static void traversal(Node node){
        System.out.println("Node Pre: " + node.data);

        for(Node child: node.children){
            System.out.println("Edge Pre: " + node.data + " - " + child.data);
            traversal(child);
            System.out.println("Edge Post: " + node.data + " - " + child.data);
        }

        System.out.println("Node Post: " + node.data);

    }

    public static void levelOrderTraversal(Node node){
         Queue<Node> q = new ArrayDeque<>();
         q.add(node);
         while(q.size() > 0){
             node = q.remove();
            System.out.print(node.data + " ");
            for(Node child: node.children){
                q.add(child);
            }
         }
         return;
     }

     public static void levelOrderLinewise(Node node){
        Queue<Node> mq = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();

        mq.add(node);

        while(mq.size() > 0){
            node = mq.remove();
            System.out.print(node.data + " ");
            for(int i = 0; i< node.children.size(); i++){
                Node child = node.children.get(i);
                cq.add(child);
            }

            if(mq.size() == 0){
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
     }

      public static void levelOrderLinewise1(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        Node temp = new Node();
        temp.data = -1;
        q.add(temp);

        while(q.size() > 0){
            node = q.remove();
            if(node.data == -1 ){
                System.out.println();
                 q.add(temp);
                 if(q.size() == 1){
                    break;
                 }
            } else {
            System.out.print(node.data + " ");
            for(Node child: node.children){
                q.add(child);
            }
            }
            
        }
      }

      public static void levelOrderLinewise2(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while(q.size() > 0){
            int count = q.size();
            for(int i= 0; i< count; i++){
                node = q.remove();
                System.out.print(node.data + " ");
                for(Node child: node.children){
                    q.add(child);
                }
            }
                System.out.println();
        }
      }

      public static void levelOrderLinewise3(Node node){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(node, 1));
        int level = 1;
        while(q.size() > 0){
            Pair p = q.remove();
            if(p.level != level){
                System.out.println();
                level += 1;
            }
            System.out.print(p.node.data + " ");
            for(Node child: p.node.children){
                q.add(new Pair(child, level + 1));
            }
            
        }
      }

     public static void levelOrderLinewiseZigZag(Node node){
        Stack<Node> mst = new Stack<>();
        Stack<Node> cst = new Stack<>();
        mst.push(node);
        int level = 1;
        while(mst.size() > 0){
            node = mst.pop();
            System.out.print(node.data + " ");
            if(level % 2 == 0){
                for(int i = (node.children.size() -1); i >=0; i--){
                    Node child = node.children.get(i);
                    cst.push(child);
                }
            } else {
                 for(int i = 0; i < node.children.size(); i++){
                    Node child = node.children.get(i);
                    cst.push(child);
                }
            }

            if(mst.size() == 0){
                mst = cst;
                cst = new Stack<>();
                System.out.println();
                level++;
            }
        }
     }

    public static void mirror(Node node){
       for(Node child: node.children){
        mirror(child);
       }
       Collections.reverse(node.children);
    }

    public static void mirror2(Node node) {
        if(node == null) {
             return;
        }
        for(int i = 0; i < node.children.size() / 2; i++) {

            int j = node.children.size() - i - 1;

            Node child1 = node.children.get(i);
             Node child2 = node.children.get(j);

             node.children.set(i, child2);
             node.children.set(j, child1);
        }

        for(Node child : node.children) {
            mirror(child);
        }
    }

    public static void removeLeaf(Node node){

        for(int i=node.children.size() -1; i>=0; i--){
            Node child = node.children.get(i);
            if(child.children.size() == 0){
                node.children.remove(child);
            } else {
            removeLeaf(child);
            }
        }
       
    }

    public static void lineariseAGenericTree(Node node){
        for(Node child: node.children){
            lineariseAGenericTree(child);
        }

        while(node.children.size()>1){
            Node l = node.children.remove(node.children.size() - 1);
            Node sl = node.children.get(node.children.size() - 1);
            Node tail = getTail(sl);
            tail.children.add(l);
            // System.out.println(l.data);
        }
    }

    public static Node getTail(Node node){
        while(node.children.size() == 1){
            node = node.children.get(0);
        }
        return node;
    }

        public static void lineariseAGenericTree2(Node node){
            //TODO: re watch lecture
        }

    public static boolean findAnElement(Node node, int element){
        boolean result = false;
        Queue<Node> q = new ArrayDeque<>();

        q.add(node);

        while(q.size() > 0){
            node = q.remove();
            int res = node.data;
            System.out.println(res);
            if(res == element){
                return true;
            } else {
                for(Node child: node.children){
                    q.add(child);
                }
            }
        }
        return result;
    }

     public static boolean findAnElement2(Node node, int element){
        if(node.data == element){
            return true;
        }

        for(Node child: node.children){
            boolean fic = findAnElement2(child, element);
            if(fic){
                return true;
            }
        }

        return false;
    }

    public static ArrayList<Integer> nodeToRootPath (Node node, int data){
        if(node.data == data){
       ArrayList<Integer> path = new ArrayList<>();
            path.addLast(node.data);
            return path;
        }

        for(Node child: node.children){
            ArrayList<Integer> pathTC = nodeToRootPath(child, data);
            if(pathTC.size() > 0){
                pathTC.addLast(node.data);
            return pathTC;
            }
        }

        return new ArrayList<>();
    }

    
    public static int lowestCommonAncestor (Node node, int d1, int d2){

        ArrayList<Integer> path1 = nodeToRootPath(node, d1);
        ArrayList<Integer> path2 = nodeToRootPath(node, d2);
        int count = 0;
        int ans = 0;
        if(path1.size()> path2.size()){
            count = path2.size();

            for(int i = count-1; i>0; i--){
                if(path1.get(path1.size()- 1) == path2.get(path2.size() - 1)){
                   ans = path1.remove(path1.size() - 1);
                   path2.remove(path2.size() - 1);
                } else {
                    break;
                }
            }
        } else {

             count = path1.size();

             for(int i = count-1; i>=0; i--){
                if(path1.get(path1.size() - 1) == path2.get(path2.size() - 1)){
                   ans = path1.remove(path1.size() - 1);
                   path2.remove(path2.size() - 1);
                } else {
                    break;
                }
            }
        }
        return ans;
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

        // display(root);
        // int size = size(root);
        // System.out.println("Size: " + size);

        // int max = max(root);
        // System.out.println("Max: " + max);

        // int height = height(root);
        // System.out.println("Height: " + height);

        // traversal(root);

        // levelOrderTraversal(root);

        // levelOrderLinewise(root);

        // levelOrderLinewise1(root);

        // levelOrderLinewise2(root);

        // levelOrderLinewise3(root);

        // levelOrderLinewiseZigZag(root);

        // System.out.println("Before Mirror:");
        // display(root);

        // mirror(root);

        // System.out.println("\nAfter Mirror:");
        // display(root);

        // removeLeaf(root);

        // lineariseAGenericTree(root);

        // display(root);

    //    boolean found = findAnElement2(root, 110);

    ArrayList<Integer> path1 = nodeToRootPath(root, 40);


    int lowestCommonAncestor = lowestCommonAncestor(root, 120, 110);

       System.out.println(lowestCommonAncestor);

     }
}


                      