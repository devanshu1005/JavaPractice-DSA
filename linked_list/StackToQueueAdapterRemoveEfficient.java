import java.util.*;

public class StackToQueueAdapterRemoveEfficient {

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

            while(mainS.size() > 0){
                helperS.push(mainS.pop());
            }

            mainS.push(val);

             while(helperS.size() > 0){
                mainS.push(helperS.pop());
            }
        }

        int remove() {
            if(mainS.size() == 0){
            return -1;
            } else{
                return mainS.pop();
            }
        }

        int peek() {
           if(mainS.size() == 0){
            return -1;
            } else{
                return mainS.peek();
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