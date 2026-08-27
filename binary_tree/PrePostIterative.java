import java.util.*;

public class PrePostIterative{

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

    public static void prePostTraversal(Node node){
        String pre = "";
        String post = "";
        String in = "";

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, 1));

        while(st.size() > 0){
            Pair top = st.peek();
            if(top.state == 1){
                pre = pre + top.node.data + " ";
                if(top.node.left != null){
                node = top.node.left;
                st.push(new Pair(node, 1));
                } 
                top.state++;
            } else if(top.state == 2){
                in = in + top.node.data + " ";
                  if(top.node.right != null){
                node = top.node.right;
                st.push(new Pair(node, 1));
                } 
                top.state++;
            } else {
                post = post + top.node.data + " ";
                st.pop();
            }
        }

        System.out.println(pre);
        System.out.println(post);

        System.out.println(in);

    }

     public static void levelOrderTraversal(Node node, int k){
        int level = 0;
        if(node == null){
            return;
        }
        Queue<Node> mq = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();

        mq.add(node);
        while(mq.size() > 0){
            Node t = mq.remove();
            if(level == k){
            System.out.print(t.data + " ");
            }
            
            if(t.left != null){
                cq.add(t.left);
            }
             if(t.right != null){
                cq.add(t.right);
            }

            if(mq.size() == 0){
                mq = cq;
                cq = new ArrayDeque<>();
                // System.out.println();
                level++;
            }
        }
    }

     public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        if(node.data == data){
            ArrayList<Integer> path = new ArrayList<>();
            path.addLast(node.data);
            return path;
        }

       if(node.left != null){
        ArrayList<Integer> left = nodeToRootPath(node.left, data);
        if (left.size() > 0){
            left.addLast(node.data);
            return left;
        }
       }

       if(node.right != null){
        ArrayList<Integer> right = nodeToRootPath(node.right, data);
        if (right.size() > 0){
            right.addLast(node.data);
            return right;
        }
       }

       return  new ArrayList<>();
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

            // prePostTraversal(root);

            // ArrayList<Integer> ans = nodeToRootPath(root, 70);
            // System.out.println(ans);

            levelOrderTraversal(root, 2);

            
    }
}