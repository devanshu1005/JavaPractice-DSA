import java.util.*;

public class StackToQueueAdapterAddEfficient {

    public static class StackToQueueAdapter {

        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueueAdapter() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            mainS.add(val);
        }

        int remove() {
             if(mainS.size() == 0){
            return -1;
            } else{
                while(mainS.size() > 1){
                    helperS.push(mainS.pop());
                }
                int ans = mainS.pop();

                Stack<Integer> tempS = new Stack<>();
                tempS = mainS;
            mainS = helperS;
            helperS = tempS;
            return ans;

            }
        }

        int peek() {
          if(mainS.size() == 0){
            return -1;
            } else{
                 while(mainS.size() > 1){
                    helperS.push(mainS.pop());
                }
                int ans = mainS.peek();
                helperS.push(mainS.pop());
                Stack<Integer> tempS = new Stack<>();
                tempS = mainS;
            mainS = helperS;
            helperS = tempS;
            return ans;
            }
        }
    }

    public static void main(String[] args) {

        StackToQueueAdapter q = new StackToQueueAdapter();

        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}